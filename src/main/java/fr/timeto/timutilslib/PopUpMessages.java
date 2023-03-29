package fr.timeto.timutilslib;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;

import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class PopUpMessages extends JPanel implements SwingerEventListener {
    private static final JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();

    public static int ERROR_MESSAGE = 0;
    public static int NORMAL_MESSAGE = 1;
    public static int DONE_MESSAGE = 2;
    public static int YES_NO_QUESTION = 3;

    private final STexturedButton okButton = new STexturedButton(Swinger.getResourceIgnorePath("/PopUpMessages/okButton-normal.png"), Swinger.getResourceIgnorePath("/PopUpMessages/okButton-hover.png"));
    private final STexturedButton yesButton = new STexturedButton(Swinger.getResourceIgnorePath("/PopUpMessages/yesButton-normal.png"), Swinger.getResourceIgnorePath("/PopUpMessages/yesButton-hover.png"));
    private final STexturedButton noButton = new STexturedButton(Swinger.getResourceIgnorePath("/PopUpMessages/noButton-normal.png"), Swinger.getResourceIgnorePath("/PopUpMessages/noButton-hover.png"));

    private static Thread ifYesThread = new Thread();
    private static Thread ifNoThread = new Thread();
    private static Thread whenOk = new Thread();

    private static JFrame initFrame(String title, String msg, int messageType) {
        Thread t = new Thread(() -> {
            BufferedImage icon;
            if (messageType == ERROR_MESSAGE) {
                icon = Swinger.getResourceIgnorePath("/PopUpMessages/errorIcon.png");
            } else if (messageType == DONE_MESSAGE) {
                icon = Swinger.getResourceIgnorePath("/PopUpMessages/doneIcon.png");
            } else if (messageType == YES_NO_QUESTION) {
                icon = Swinger.getResourceIgnorePath("/PopUpMessages/inWorkIcon.png");
            } else {
                icon = Swinger.getResourceIgnorePath("/PopUpMessages/newIcon.png");
            }

            frame.setTitle(title);
            frame.setSize(350, 225);
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(exitListener);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(icon);
            frame.setResizable(false);
            frame.setContentPane(panel = new PopUpMessages(msg, messageType));

            frame.setVisible(true);
        });
        t.start();

        return frame;
    }

    private static WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            if (whenOk != null) {
                whenOk.start();
            }
            frame.dispose();
        }
    };

    private PopUpMessages(String message, int messageType) {
        this.setLayout(null);

        Icon icon;
        if (messageType == ERROR_MESSAGE) {
            icon = new ImageIcon(Swinger.getResourceIgnorePath("/PopUpMessages/errorIcon.png"));
        } else if (messageType == DONE_MESSAGE) {
            icon = new ImageIcon(Swinger.getResourceIgnorePath("/PopUpMessages/doneIcon.png"));
        } else if (messageType == YES_NO_QUESTION) {
            icon = new ImageIcon(Swinger.getResourceIgnorePath("/PopUpMessages/inWorkIcon.png"));
        } else {
            icon = new ImageIcon(Swinger.getResourceIgnorePath("/PopUpMessages/newIcon.png"));
        }

        JLabel image = new JLabel();
        image.setBounds(30, 40, 64, 64);
        image.setIcon(icon);
        this.add(image);

        JTextPane messageArea = new JTextPane();
        messageArea.setForeground(Color.WHITE);
        messageArea.setFont(CustomFonts.robotoBoldFont.deriveFont(16f));
        messageArea.setCaretColor(Color.RED);
        messageArea.setSelectionColor(new Color(255, 20, 20, 200));
        messageArea.setOpaque(false);
        messageArea.setBorder(null);
        messageArea.setEditable(false);

        messageArea.setEditorKit(new MyEditorKit());
        SimpleAttributeSet attrs = new SimpleAttributeSet();
    /*    StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_CENTER);*/
        StyledDocument doc = (StyledDocument) messageArea.getDocument();
        try {
            doc.insertString(0, "111\n2222222\n3333", attrs);
        } catch (BadLocationException ignored) {}
        doc.setParagraphAttributes(0, doc.getLength() - 1, attrs, false);

        messageArea.setAlignmentX(SwingConstants.LEFT);

        messageArea.setText(message);

        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setBounds(125, 27, 190, 95);
        scrollPane.setOpaque(false);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getVerticalScrollBar().setUnitIncrement(14);

        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        this.add(scrollPane);

        if (Objects.equals(messageType, YES_NO_QUESTION)) {
            yesButton.setBounds(112, 138);
            yesButton.addEventListener(this);
            this.add(yesButton);

            noButton.setBounds(185, 138);
            noButton.addEventListener(this);
            this.add(noButton);
        } else {
            okButton.setBounds(148, 138);
            okButton.addEventListener(this);
            this.add(okButton);
        }

    }

    public static JFrame normalMessage(String title, String message) {
        return initFrame(title, message, NORMAL_MESSAGE);
    }

    public static JFrame normalMessage(String title, String message, Thread whenOkClicked) {
        whenOk = whenOkClicked;
        return initFrame(title, message, NORMAL_MESSAGE);
    }

    public static JFrame errorMessage(String title, String message) {
        return initFrame(title, message, ERROR_MESSAGE);
    }

    public static JFrame errorMessage(String title, String message, Thread whenOkClicked) {
        whenOk = whenOkClicked;
        return initFrame(title, message, ERROR_MESSAGE);
    }

    public static JFrame doneMessage(String title, String message) {
        return initFrame(title, message, DONE_MESSAGE);
    }

    public static JFrame doneMessage(String title, String message, Thread whenOkClicked) {
        whenOk = whenOkClicked;
        return initFrame(title, message, DONE_MESSAGE);
    }

    public static JFrame yesNoMessage(String title, String message, Thread ifYes, Thread ifNo) {
        ifYesThread = ifYes;
        ifNoThread = ifNo;

        return initFrame(title, message, YES_NO_QUESTION);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(18, 18, 18));
        g2d.fillRect(0, 0, 350, 225);

    }

    @Override
    public void onEvent(SwingerEvent e) {
        if (e.getSource() == okButton) {
            if (whenOk != null) {
                whenOk.start();
                whenOk = null;
            }
            frame.dispose();
        } else if (e.getSource() == yesButton) {
            ifYesThread.start();
            ifYesThread = null;
            frame.dispose();
        } else if (e.getSource() == noButton) {
            ifNoThread.start();
            ifNoThread = null;
            frame.dispose();
        }
    }

    class MyEditorKit extends StyledEditorKit {

        public ViewFactory getViewFactory() {
            return new StyledViewFactory();
        }

        class StyledViewFactory implements ViewFactory {

            public View create(Element elem) {
                String kind = elem.getName();
                if (kind != null) {
                    if (kind.equals(AbstractDocument.ContentElementName)) {

                        return new LabelView(elem);
                    } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                        return new ParagraphView(elem);
                    } else if (kind.equals(AbstractDocument.SectionElementName)) {

                        return new CenteredBoxView(elem, View.Y_AXIS);
                    } else if (kind.equals(StyleConstants.ComponentElementName)) {
                        return new ComponentView(elem);
                    } else if (kind.equals(StyleConstants.IconElementName)) {

                        return new IconView(elem);
                    }
                }

                return new LabelView(elem);
            }

        }
    }

    class CenteredBoxView extends BoxView {
        public CenteredBoxView(Element elem, int axis) {

            super(elem, axis);
        }

        protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets,
                                       int[] spans) {

            super.layoutMajorAxis(targetSpan, axis, offsets, spans);
            int textBlockHeight = 0;
            int offset = 0;

            for (int i = 0; i < spans.length; i++) {
                textBlockHeight += spans[i];
            }
            offset = (targetSpan - textBlockHeight) / 2;
            for (int i = 0; i < offsets.length; i++) {
                offsets[i] += offset;
            }

        }
    }
}
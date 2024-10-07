package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class SetPlaceholder extends JTextField{
	
	private String placeholder;
	
	public SetPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        setForeground(Color.LIGHT_GRAY);
        setText(placeholder);

        // Listener para manejar el enfoque
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(Color.LIGHT_GRAY);
                    setText(placeholder);
                }
            }
        });
    }
	
	@Override
    public void setText(String t) {
        super.setText(t);
        if (t.isEmpty()) {
            setForeground(Color.LIGHT_GRAY);
        } else {
            setForeground(Color.BLACK);
        }
    }

}

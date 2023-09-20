/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa.mapaprog2;


import dao.UsuarioDAO;

import javax.swing.*;
import java.awt.event.*;

public class TelaInicial extends JFrame {
    JTextField loginField;
    JPasswordField senhaField;
    JButton entrarButton, novoUsuarioButton;

    public TelaInicial() {
        setTitle("Tela Inicial");
        setSize(350, 350);
        setLayout(null);
        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(10, 50, 40, 30);  // Ajuste as coordenadas como necessário
        add(loginLabel);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(10, 100, 50, 30);  // Ajuste as coordenadas como necessário
        add(senhaLabel);
        loginField = new JTextField();
        loginField.setBounds(50, 50, 200, 30);
        add(loginField);

        senhaField = new JPasswordField();
        senhaField.setBounds(50, 100, 200, 30);
        add(senhaField);

        entrarButton = new JButton("Entrar");
        entrarButton.setBounds(50, 150, 100, 30);
        add(entrarButton);

        novoUsuarioButton = new JButton("Novo Usuário");
        novoUsuarioButton.setBounds(160, 150, 120, 30);
        add(novoUsuarioButton);

        entrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UsuarioDAO dao = new UsuarioDAO();
                if (dao.validarLogin(loginField.getText(), new String(senhaField.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Acesso Autorizado");
                } else {
                    JOptionPane.showMessageDialog(null, "Acesso Negado");
                }
            }
        });

        novoUsuarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NovoUsuario();
            }
        });

        setVisible(true);
    }
}

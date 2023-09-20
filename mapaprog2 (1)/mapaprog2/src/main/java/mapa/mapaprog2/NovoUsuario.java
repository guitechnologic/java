/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa.mapaprog2;


import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.event.*;

public class NovoUsuario extends JFrame {
    JTextField nomeField, loginField, emailField;
    JPasswordField senhaField;
    JButton salvarButton;

    public NovoUsuario() {
        setTitle("Cadastrar Novo Usuário");
        setSize(350, 350);
        setLayout(null);
        
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 50, 40, 30);  // Ajuste as coordenadas como necessário
        add(nomeLabel);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(10, 100, 40, 30);  // Ajuste as coordenadas como necessário
        add(loginLabel);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(10, 150, 50, 30);  // Ajuste as coordenadas como necessário
        add(senhaLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 200, 40, 30);  // Ajuste as coordenadas como necessário
        add(emailLabel);

        nomeField = new JTextField();
        nomeField.setBounds(50, 50, 200, 30);
        add(nomeField);

        loginField = new JTextField();
        loginField.setBounds(50, 100, 200, 30);
        add(loginField);

        senhaField = new JPasswordField();
        senhaField.setBounds(50, 150, 200, 30);
        add(senhaField);

        emailField = new JTextField();
        emailField.setBounds(50, 200, 200, 30);
        add(emailField);

        salvarButton = new JButton("Salvar");
        salvarButton.setBounds(100, 250, 100, 30);
        add(salvarButton);

        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                usuario.setNome(nomeField.getText());
                usuario.setLogin(loginField.getText());
                usuario.setSenha(new String(senhaField.getPassword()));
                usuario.setEmail(emailField.getText());

                UsuarioDAO dao = new UsuarioDAO();
                if (dao.cadastrarUsuario(usuario)) {
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                    dispose();
                }
            }
        });

        setVisible(true);
    }
}

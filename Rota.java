import javax.swing.JOptionPane;

public class Rota {
    public void planejarDia() {
        int quantidadeRotas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de rotas do dia:"));

        double totalKm = 0;
        double totalLitros = 0;

        for (int i = 1; i <= quantidadeRotas; i++) {
            double kmRota = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de km percorridos na rota " + i + ":"));
            totalKm += kmRota;

            double litrosNecessarios = kmRota / 2.5;
            totalLitros += litrosNecessarios;
        }

        double precoLitroDiesel = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do litro do óleo diesel:"));
        double custoTotal = totalLitros * precoLitroDiesel;

        JOptionPane.showMessageDialog(null,
                "Total de km percorridos: " + totalKm + " km\n" +
                "Quantidade de litros necessários: " + totalLitros + " litros\n" +
                "Custo total: R$" + custoTotal);
    }
}

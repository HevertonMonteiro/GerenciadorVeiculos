package gerenciador;

import java.util.ArrayList;
import java.util.Scanner;

class Veiculo {
    private String modelo;
    private int ano;

    public Veiculo(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Ano: " + ano;
    }
}

public class gerenciarVeiculos {
    private static ArrayList<Veiculo> veiculos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1️⃣ Adicionar Veículo");
            System.out.println("2️⃣ Exibir Veículos");
            System.out.println("3️⃣ Atualizar Veículo");
            System.out.println("4️⃣ Excluir Veículo");
            System.out.println("5️⃣ Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    adicionarVeiculo();
                    break;
                case 2:
                    exibirVeiculos();
                    break;
                case 3:
                    atualizarVeiculo();
                    break;
                case 4:
                    excluirVeiculo();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void adicionarVeiculo() {
        System.out.print("Insira o modelo do veículo: ");
        String modelo = sc.nextLine();
        System.out.print("Insira o ano do veículo: ");
        int ano = sc.nextInt();
        sc.nextLine(); 

        Veiculo veiculo = new Veiculo(modelo + " ", + ano);
        veiculos.add(veiculo);
        System.out.println("Veículo adicionado com sucesso!");
    }

    private static void exibirVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            System.out.println("Veículos cadastrados:");
            for (int i = 0; i < veiculos.size(); i++) {
                System.out.println((i + 1) + ". " + veiculos.get(i));
            }
        }
    }

    private static void atualizarVeiculo() {
        exibirVeiculos();
        System.out.print("Escolha o número do veículo que deseja atualizar: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine(); 

        if (indice >= 0 && indice < veiculos.size()) {
            System.out.print("Insira o novo modelo do veículo: ");
            String novoModelo = sc.nextLine();
            System.out.print("Insira o novo ano do veículo: ");
            int novoAno = sc.nextInt();
            sc.nextLine(); 

            Veiculo veiculo = veiculos.get(indice);
            veiculo.setModelo(novoModelo);
            veiculo.setAno(novoAno);
            System.out.println("Veículo atualizado com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void excluirVeiculo() {
        exibirVeiculos();
        System.out.print("Escolha o número do veículo que deseja excluir: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine(); 

        if (indice >= 0 && indice < veiculos.size()) {
            veiculos.remove(indice);
			System.out.println("Veiculo excluido com sucesso! ");
			sc.nextLine();
		} else {
			System.out.println("Veiculo não encontrado! ");
		}
	}


}

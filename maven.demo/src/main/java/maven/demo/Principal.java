package maven.demo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        DAO dao = new DAO();
        dao.conectar();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Mostrar carros");
            System.out.println("2. Inserir carro");
            System.out.println("3. Remover carro");
            System.out.println("4. Alterar carro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            Carro[] carros = dao.getCarros();
            switch (opcao) {
                case 1:
                    System.out.println("==== Mostrar carros ====");
                    for (int i = 0; i < carros.length; i++) {
                        System.out.println(carros[i].toString());
                    }
                    break;

                case 2:
                    System.out.print("Digite o modelo do carro: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Digite a marca do carro: ");
                    String marca = scanner.nextLine();
                    System.out.print("Digite o ano do carro: ");
                    String ano = scanner.nextLine();
                    System.out.print("Digite a placa do carro: ");
                    String placa = scanner.nextLine();
                    
                    Carro novoCarro = new Carro(modelo, marca, ano, placa);
                    if (dao.inserirCarro(novoCarro)) {
                        System.out.println("Inserção com sucesso -> " + novoCarro.toString());
                    } else {
                        System.out.println("Erro ao inserir carro.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do carro para remover: ");
                    String idRemover = scanner.nextLine();
                    scanner.nextLine();
                    if (dao.excluirCarro(idRemover)) {
                        System.out.println("Carro removido com sucesso.");
                    } else {
                        System.out.println("Erro ao remover carro.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do carro para alterar: ");
                    String idAlterar = scanner.nextLine();
                    scanner.nextLine(); 
                    System.out.print("Digite a nova placa do carro: ");
                    String novaPlaca = scanner.nextLine();
                    
                    Carro carroParaAlterar = new Carro();
                    
                    boolean achou = false;
                    for(int i = 0; i < carros.length; i++) {
                    	if(carros[i].getId() == idAlterar) {
                    		carroParaAlterar = carros[i];
                    		achou = true;
                    	}
                    }
                    
                    if(!achou) return;
                    
                    if (carroParaAlterar != null) {
                        carroParaAlterar.setPlaca(novaPlaca);
                        if (dao.atualizarCarro(carroParaAlterar)) {
                            System.out.println("Carro atualizado com sucesso.");
                        } else {
                            System.out.println("Erro ao atualizar carro.");
                        }
                    } else {
                        System.out.println("Carro não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }

        dao.close();
        scanner.close();
    }
}

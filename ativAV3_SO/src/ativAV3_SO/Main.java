package ativAV3_SO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystemSimulator fileSystemSimulator = new FileSystemSimulator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Simulador de Sistema de Arquivos");
        printHelp();

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equals("exit")) {
                System.out.println("Encerrando o simulador.");
                break;
            }

            switch (parts[0]) {
                case "cf":
                    if (parts.length == 3) {
                        fileSystemSimulator.createFile(parts[1], parts[2]);
                    } else {
                        System.out.println("createFile: cf <caminho> <nomeDoArquivo>");
                    }
                    break;
                case "df":
                    if (parts.length == 3) {
                        fileSystemSimulator.deleteFile(parts[1], parts[2]);
                    } else {
                        System.out.println("deleteFile: df <caminho> <nomeDoArquivo>");
                    }
                    break;
                case "rf":
                    if (parts.length == 4) {
                        fileSystemSimulator.renameFile(parts[1], parts[2], parts[3]);
                    } else {
                        System.out.println("renameFile: rf <caminho> <nomeAntigo> <nomeNovo>");
                    }
                    break;
                case "cdir":
                    if (parts.length == 3) {
                        fileSystemSimulator.createDirectory(parts[1], parts[2]);
                    } else {
                        System.out.println("createDirectory: cdir <caminho> <nomeDoDiretorio>");
                    }
                    break;
                case "ddir":
                    if (parts.length == 3) {
                        fileSystemSimulator.deleteDirectory(parts[1], parts[2]);
                    } else {
                        System.out.println("deleteDirectory: ddir <caminho> <nomeDoDiretorio>");
                    }
                    break;
                case "rdir":
                    if (parts.length == 4) {
                        fileSystemSimulator.renameDirectory(parts[1], parts[2], parts[3]);
                    } else {
                        System.out.println("renameDirectory: rdir <caminho> <nomeAntigo> <nomeNovo>");
                    }
                    break;
                case "ls":
                    if (parts.length == 2) {
                        List<String> files = fileSystemSimulator.listFiles(parts[1]);
                        if (files.isEmpty()) {
                            System.out.println("Nenhum arquivo encontrado.");
                        } else {
                            System.out.println("Arquivos no diretório " + parts[1] + ":");
                            for (String file : files) {
                                System.out.println(file);
                            }
                        }
                    } else {
                        System.out.println("listFiles: ls <caminho>");
                    }
                    break;
                case "help":
                    printHelp();
                    break;
                default:
                    System.out.println("Comando desconhecido. Digite 'help' para ver a lista de comandos.");
                    break;
            }
        }

        scanner.close();
    }

    private static void printHelp() {
        System.out.println("Comandos disponíveis:");
        System.out.println("  createFile: cf <caminho> <nomeDoArquivo>  - Cria um arquivo no diretório especificado");
        System.out.println("  deleteFile: df <caminho> <nomeDoArquivo>  - Apaga um arquivo no diretório especificado");
        System.out.println("  renameFile: rf <caminho> <nomeAntigo> <nomeNovo>  - Renomeia um arquivo no diretório especificado");
        System.out.println("  createDirectory: cdir <caminho> <nomeDoDiretorio>  - Cria um diretório no caminho especificado");
        System.out.println("  deleteDirectory: ddir <caminho> <nomeDoDiretorio>  - Apaga um diretório no caminho especificado");
        System.out.println("  renameDirectory: rdir <caminho> <nomeAntigo> <nomeNovo>  - Renomeia um diretório no caminho especificado");
        System.out.println("  listFiles: ls <caminho>  - Lista todos os arquivos no diretório especificado");
        System.out.println("  help  - Mostra esta lista de comandos");
        System.out.println("  exit  - Encerra o simulador");
    }
}



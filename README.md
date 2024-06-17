-Exemplo de Uso do Sistema de Arquivos-

Criação de Diretório:
> createDirectory / root
Diretório criado: root

Listagem de Arquivos no Diretório /:
> listFiles /
Arquivos no diretório /:
root

Criação de Subdiretório dentro de root:
> createDirectory /root subdir
Diretório criado: subdir

Criação de Arquivo em subdir:
> createFile /root/subdir file1.txt
Arquivo criado: file1.txt

Listagem de Arquivos no Diretório /root/subdir:
> listFiles /root/subdir
Arquivos no diretório /root/subdir:
file1.txt

Renomeação de Arquivo file1.txt para file2.txt:
> renameFile /root/subdir file1.txt file2.txt
Arquivo renomeado: file1.txt para file2.txt

Exclusão de Arquivo file2.txt:
> deleteFile /root/subdir file2.txt
Arquivo apagado: file2.txt

Exclusão de Subdiretório subdir:
> deleteDirectory /root subdir
Diretório apagado: subdir

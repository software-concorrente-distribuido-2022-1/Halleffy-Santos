import socket
import threading

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    backlog = 5
    sock.bind(('', porta))
    sock.listen(backlog)

    print('Server criado')

    while True:
        conec, addr = sock.accept()
        threading.Thread(target=Maioridade, args =(conec, addr), daemon = True).start()

        if str(input()) == 'x':
            exit()

def Maioridade(conec, addr):
    print('Conexao estabelecida')

    data = conec.recv(1024).decode()

    valor = ""
    args = []
    for x in data:
        if x == ' ':
            args.append(valor)
            valor = ""
        valor += x
    args.append(valor)

    print(data)
    print(args[0] + ' ' + args[1] + ' ' + args[2])

    n1 = float(args[0])
    n2 = float(args[1])
    n3 = float(args[2])
    
    if (n1 + n2)/2 >= 7 or ((n1+n2)/2 > 3 and (n1+n2)/2 < 7 and (n1+n2+n3)/3 >= 5):
        conec.send('Aprovado\n'.encode())
    else:
        conec.send('Reprovado\n'.encode())

if __name__ == '__main__':
    main()
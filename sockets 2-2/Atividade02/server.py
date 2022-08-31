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

    args = ["", ""]
    ind = 0
    for x in data:
        if x == ' ':
            ind += 1
        args[ind] += x

    sexo = args[0]
    idade = float(args[1])
    print(sexo + ' ' + str(idade))

    if (sexo == "masculino" and idade >= 18) or (sexo == 'feminino' and idade >= 21):
        conec.send('Maioridade alcancada\n'.encode())
    
    else:
        conec.send('Maioridade nao alcancada\n'.encode())

if __name__ == '__main__':
    main()
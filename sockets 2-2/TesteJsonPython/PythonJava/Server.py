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
        threading.Thread(target=Acao, args =(conec, addr), daemon = True).start()

def Acao(conec, addr):
    print('Conexao estabelecida')

    data = conec.recv(1024).decode()

    print(data)

    conec.send('Mensagem recebida'.encode())

if __name__ == '__main__':
    main()
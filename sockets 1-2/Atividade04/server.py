import socket
import threading

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    sock.bind(('', porta))
    sock.listen(5)

    print('Server criado')

    while True:
        conec, addr = sock.accept()
        threading.Thread(target = AnalisaPeso, args = (conec, addr), daemon = True).start()

def AnalisaPeso(conec, addr):
    data = conec.recv(1004).decode()

    args = ["", ""]
    ind = 0
    for x in data:
        if x == ' ':
            ind += 1
        args[ind] += x

    print('valor recebido')
    if args[0] == 'masculino':
        conec.send( str(72.7 * float(args[1]) - 58.0).encode() )

    if args[1] == 'feminino':
        conec.send( str(62.1 * float(args[1]) - 44.7).encode() )


if __name__ == '__main__':
    main()
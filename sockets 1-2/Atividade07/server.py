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
        threading.Thread(target = AnalisaAposentadoria, args = (conec, addr), daemon = True).start()

def AnalisaAposentadoria(conec, addr):
    data = conec.recv(1004).decode()

    args = [""]
    ind = 0
    for x in data:
        if x == ' ':
            ind += 1
        args[ind] += x

    resultado = True
    if int(args[0]) < 65:
        resultado = False

    if int(args[1] < 30):
        resultado = False

    if int(args[0]) < 60 or int(args[1]) < 25:
        resultado = False
    

    conec.send( 'Pode aposentar'.encode() ) if resultado else conec.send( 'Nao pode aposentar'.encode() )

if __name__ == '__main__':
    main()
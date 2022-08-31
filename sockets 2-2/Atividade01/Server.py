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
        threading.Thread(target=ReajusteSalarial, args =(conec, addr), daemon = True).start()

        if str(input()) == 'x':
            exit()

def ReajusteSalarial(conec, addr):
    print('Conexao estabelecida')

    data = conec.recv(1024).decode()

    args = ["", ""];
    ind = 0;
    for x in data:
        if x == ' ':
            ind += 1
        args[ind] += x

    cargo = args[0]
    salario = float(args[1])
    print(cargo + ' ' + str(salario))

    if cargo == "Operador":
        salario *= 1.2
        conec.send((str(salario) + '\n').encode())
    
    elif cargo == "Programador":
        salario *= 1.18;
        conec.send((str(salario) + '\n').encode())
    
    else:
        conec.send(("Cargo inserido invalido: " + cargo + '\n').encode())

if __name__ == '__main__':
    main()
class Titulo{
    #id 
    #nome 
    #qtde 
    #edicao
    #genero 
    constructor(id,nome,qtde,edicao,genero){
        this.#id = id;
        this.#nome = nome;
        this.#qtde = qtde;
        this.#edicao = edicao;
        this.#genero = genero;
    }

    set Id(value) {this.#id = value; }

    set Nome(value) {this.#nome = nome; }

    set Qtde(value) {this.#qtde = qtde; }

    set Edicao(value) { this.#edicao = value; }

    set Genero(value) { this.#genero = genero; }

    get Id() { return this.#id; }

    get Nome() { return this.#nome; }

    get Qtde() { return this.#qtde; }

    get Edicao() { return this.#edicao; }

    get Genero() { return this.#genero; }
}
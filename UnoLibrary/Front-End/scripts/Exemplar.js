class Exemplar{
    #status
    #data
    #titulo
    constructor(status,data,titulo){
        this.#data = data;
        this.#status = status;
        this.#titulo = titulo;
    }

    set Status(value) {this.#status = value; }

    set Data(value) {this.#data = value; }

    set Titulo(value) {this.#titulo = value; }

    get Status() { return this.#status; }

    get Data() { return this.#data; }

    get Titulo() { return this.#titulo; }
}

package br.csi.modelo;


public class Filme {
    
    private String itemID;
    private String valor;
    private String nota;
    private String idUsuario;
    private String titulo;

    public Filme() {
    }

    
    public Filme(String itemID, String valor, String nota, String idUsuario) {
        this.itemID = itemID;
        this.valor = valor;
        this.nota = nota;
        this.idUsuario = idUsuario;
    }
    

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Filme{" + 
                "itemID=" + itemID + ", "
                + "valor=" + valor + ","
                + " nota=" + nota + ", "
                + "idUsuario=" + idUsuario + ","
                + " titulo=" + titulo + '}';
    }
    
    
}

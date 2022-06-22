package edu.ifes.ci.si.les.slol.model.reports;

/**
 *
 * @author Rafael Vargas Mesquita
 */
public class RelatorioDeEmprestimoPorClienteTotalQuantidade {

    private String cliente;
    private Double total;
    private Integer quantidade;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}

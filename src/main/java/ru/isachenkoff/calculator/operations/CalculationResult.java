package ru.isachenkoff.calculator.operations;

import ru.isachenkoff.calculator.util.FormatUtil;

import javax.persistence.*;

@Entity
public class CalculationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private Double result;
    private String statement;
    
    public CalculationResult() {}
    
    public CalculationResult(Double result, String statement) {
        this.result = (result != null && Double.isNaN(result)) ? null : result;
        this.statement = statement;
    }
    
    public Long getId() {return id;}
    
    public void setId(Long id) {this.id = id;}
    
    public Double getResult() {
        return result;
    }
    
    public void setResult(Double result) {
        this.result = result;
    }
    
    public String getFormattedResult() {
        return FormatUtil.format(result);
    }
    
    public String getStatement() {
        return statement;
    }
    
    public void setStatement(String statement) {
        this.statement = statement;
    }
    
    @Override
    public String toString() {
        return statement + FormatUtil.format(result);
    }
}

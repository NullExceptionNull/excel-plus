package io.github.biezhi.excel.plus.writer;

import io.github.biezhi.excel.plus.enums.ExcelType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Collection;
import java.util.function.Function;

/**
 * Excel exporter
 *
 * @author biezhi
 * @date 2018/2/4
 */
public class Exporter<T> {

    private String        templatePath;
    private ExcelType     excelType;
    private Collection<T> data;

    private Function<Workbook, CellStyle> headerStyle;
    private Function<Workbook, CellStyle> columnStyle;

    public static <T> Exporter<T> create(Collection<T> data) {
        Exporter<T> exporter = new Exporter<>();
        exporter.data = data;
        return exporter;
    }

    public Exporter<T> headerStyle(Function<Workbook, CellStyle> function) {
        this.headerStyle = function;
        return this;
    }

    public Exporter<T> columnStyle(Function<Workbook, CellStyle> function) {
        this.columnStyle = function;
        return this;
    }

    public Exporter<T> byTemplate(String templatePath) {
        this.templatePath = templatePath;
        return this;
    }

    public Function<Workbook, CellStyle> getHeaderStyle() {
        return headerStyle;
    }

    public Function<Workbook, CellStyle> getColumnStyle() {
        return columnStyle;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setExcelType(ExcelType excelType) {
        this.excelType = excelType;
    }

    public ExcelType getExcelType() {
        if (null == excelType) {
            return ExcelType.XLS;
        }
        return excelType;
    }

}

package service;

import java.awt.Component;
import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ExcelService {

    public static void gerarRelatorio(DefaultTableModel model, String caminhoArquivo) {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Relatório");

            int linhaExcel = 0;

            // 🔹 Cabeçalho
            Row header = sheet.createRow(linhaExcel++);
            header.createCell(0).setCellValue("Modalidade");
            header.createCell(1).setCellValue("Quantidade");

            // 🔹 Dados
            for (int i = 0; i < model.getRowCount(); i++) {

                Row row = sheet.createRow(linhaExcel++);

                Object modalidade = model.getValueAt(i, 0);
                Object quantidade = model.getValueAt(i, 1);

                row.createCell(0).setCellValue(modalidade != null ? modalidade.toString() : "");
                row.createCell(1).setCellValue(quantidade != null ? quantidade.toString() : "");
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            try (FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {
                workbook.write(fileOut);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar Excel: " + e.getMessage());
        }
    }
    
    public static void gerarModelo(String caminhoArquivo) {

    try (Workbook workbook = new XSSFWorkbook()) {

        Sheet sheet = workbook.createSheet("Relatório");

        int linha = 0;

        // 🔹 Título
        Row titulo = sheet.createRow(linha++);
        titulo.createCell(0).setCellValue("RELATÓRIO DE SERVIÇO");

        linha++; // linha em branco

        // 🔹 Conteúdo presetado
        String[] dados = {
            "Publicadores - Quantidade",
            "Publicadores - Relatando",
            "Publicadores - Estudos",
            "Pioneiro Auxiliar - Quantidade",
            "Pioneiro Auxiliar - Estudos",
            "Pioneiro Regular - Quantidade",
            "Pioneiro Regular - Estudos",
            "Total de Estudos"
        };

        for (String item : dados) {
            Row row = sheet.createRow(linha++);
            row.createCell(0).setCellValue(item);
            row.createCell(1).setCellValue(""); // valor vazio
        }

        // Ajusta largura
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        try (FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {
            workbook.write(fileOut);
        }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar Excel: " + e.getMessage());
        }
    }
    
    public static void gerarRelatorioComModelo(File arquivoDestino) throws Exception {

        // Carrega modelo
        InputStream modelo = ExcelService.class.getResourceAsStream("/resources/modelo_relatorio.xlsx");

        Workbook workbook = new XSSFWorkbook(modelo);
        Sheet sheet = workbook.getSheetAt(0);

        /** Altera os dados
         * 
         * sheet.getRow(linha).getCell(célula).setCellValue(valor_a_ser_inserido);
         * sheet.getRow(2).getCell(1).setCellValue(8);
         * sheet.getRow(3).getCell(1).setCellValue(5);
         * 
         */
        
        // Salva arquivo
        FileOutputStream fos = new FileOutputStream(arquivoDestino);
        workbook.write(fos);

        fos.close();
        workbook.close();
    }
}
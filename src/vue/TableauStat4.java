package vue;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

import controleur.ConvertCSV;

public class TableauStat4 extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    private final String[] entetes = {"Departements", "NO2", "PM10", "PM25" };
    private final HashMap<String, Double> moyDepartementNO2;
    private final HashMap<String, Double> moyDepartementPM10;
    private final HashMap<String, Double> moyDepartementPM25;

    public TableauStat4(HashMap<String, Double> moyDepartementNO2, HashMap<String, Double> moyDepartementPM10, HashMap<String, Double> moyDepartementPM25) {
        this.moyDepartementNO2 = moyDepartementNO2;
        this.moyDepartementPM10 = moyDepartementPM10;
        this.moyDepartementPM25 = moyDepartementPM25;
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }
    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public int getRowCount() {
        return ConvertCSV.listeDepartements.size();
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
        case 0:
            return ConvertCSV.listeDepartements.get(rowIndex);
        case 1:
            return moyDepartementNO2.get(ConvertCSV.listeDepartements.get(rowIndex));

        case 2:
            return moyDepartementPM10.get(ConvertCSV.listeDepartements.get(rowIndex));

        case 3:
            return moyDepartementPM25.get(ConvertCSV.listeDepartements.get(rowIndex));

        default:
            throw new IllegalArgumentException();
        }
    }
}

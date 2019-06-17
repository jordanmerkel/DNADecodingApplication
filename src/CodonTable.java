// CodonTable.java
// translate between DNA and ammino acids
//----------------------------------------------------------------------------------
// $Revision: 332 $
// $Date: 2005/04/03 19:15:04 $
//-------------------------------------------------------------------------------------
/*
 * Copyright (C) 2006 by Institute for Systems Biology,
 * Seattle, Washington, USA.  All rights reserved.
 *
 * This source code is distributed under the GNU Lesser
 * General Public License, the text of which is available at:
 *   http://www.gnu.org/copyleft/lesser.html
 */

/**
 * CodonTable.java:
 * Adapted from ISB CodonTable.java (see original header above); for academic instruction purposes only
 *
 * @author Jordan Merkel and Professor Rossi from Lab8
 */

//---------------------------------------------------------------------------------
import java.util.HashMap;

//---------------------------------------------------------------------------------
public class CodonTable
    {
    private HashMap<String, String> table = new HashMap<> ();

    //----------------------------------------------------------------------------------
    public String getAminoAcidSequence (String codon)
    {
        String uCodon = codon.toUpperCase();
        return table.get(uCodon);
    }
    //----------------------------------------------------------------------------------
    public CodonTable()
    {
        initializeTable ();
    }
    //----------------------------------------------------------------------------------
    public void initializeTable ()
    {
        table.put ("TTT", "F");
        table.put ("TTC", "F");
        table.put ("TTA", "L");
        table.put ("TTG", "L");
        table.put ("TCT", "S");
        table.put ("TCC", "S");
        table.put ("TCA", "S");
        table.put ("TCG", "S");
        table.put ("TAT", "Y");
        table.put ("TAC", "Y");
        table.put ("TGT", "C");
        table.put ("TGC", "C");
        table.put ("TGG", "W");
        table.put ("CTT", "L");
        table.put ("CTC", "L");
        table.put ("CTA", "L");
        table.put ("CTG", "L");
        table.put ("CCT", "P");
        table.put ("CCC", "P");
        table.put ("CCA", "P");
        table.put ("CCG", "P");
        table.put ("CAT", "H");
        table.put ("CAC", "H");
        table.put ("CAA", "Q");
        table.put ("CAG", "Q");
        table.put ("CGT", "R");
        table.put ("CGC", "R");
        table.put ("CGA", "R");
        table.put ("CGG", "R");
        table.put ("ATT", "I");
        table.put ("ATC", "I");
        table.put ("ATA", "I");
        table.put ("ATG", "M");
        table.put ("ACT", "T");
        table.put ("ACC", "T");
        table.put ("ACA", "T");
        table.put ("ACG", "T");
        table.put ("AAT", "N");
        table.put ("AAC", "N");
        table.put ("AAA", "K");
        table.put ("AAG", "K");
        table.put ("AGT", "S");
        table.put ("AGC", "S");
        table.put ("AGA", "R");
        table.put ("AGG", "R");
        table.put ("GTT", "V");
        table.put ("GTC", "V");
        table.put ("GTA", "V");
        table.put ("GTG", "V");
        table.put ("GCT", "A");
        table.put ("GCC", "A");
        table.put ("GCA", "A");
        table.put ("GCG", "A");
        table.put ("GAT", "D");
        table.put ("GAC", "D");
        table.put ("GAA", "E");
        table.put ("GAG", "E");
        table.put ("GGT", "G");
        table.put ("GGC", "G");
        table.put ("GGA", "G");
        table.put ("GGG", "G");
        table.put("TAA","STOP");
        table.put("TAG","STOP");
        table.put("TGA","STOP");
    } // initializeTable
}
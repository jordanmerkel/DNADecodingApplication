/**
 * DNAStrand.java:
 * This class uses several methods like finding DNA strand, mRNA, or Amino Acid Sequence
 *
 * @author Jordan Merkel
 */
public class DNAStrand
{
    private String dna; //The dna strand represented as text

    /**
     * One argument constructor, initializes the class with the dna string
     *
     * @param dna The dna strand the class is representing
     */
    public DNAStrand( String dna )
    {
        this.dna = dna;
        this.scrubDNA();

        //Need to handle situation where a DNA strand does not evenly slice
        if( this.dna.length() % 3 != 0 )
        {
            if( this.dna.length() % 3 == 1 )
            {
                this.dna += "AA";
            }
            else if( this.dna.length() %3 == 2 )
            {
                this.dna += "A";
            }
        }
    }

    /**
     * Cleans up the DNA, removing X's and N's
     */
    private void scrubDNA()
    {
        this.dna = this.dna.replaceAll( "X", "A" );
        this.dna = this.dna.replaceAll( "N", "A" );
    }

    /**
     * this function changes the sequence into mRNA
     * @param dna
     * @return dna
     */
    public String covertmRNA(String dna)
    {
        dna = dna.replaceAll("A", "U");
        dna = dna.replaceAll("T", "A");
        dna = dna.replaceAll("C", "X");
        dna = dna.replaceAll("G", "C");
        dna = dna.replaceAll("X", "G");

        return dna;
    }

    /**
     * Finds the protein coding regions and prints them to the screen
     */
    public void findPCRs()
    {
        boolean inSeq = false;

        for( int i = 0; i < this.dna.length(); i += 3 ) {
            char c1 = this.dna.charAt(i);
            char c2 = this.dna.charAt(i + 1);
            char c3 = this.dna.charAt(i + 2);

            String codon = new Character(c1).toString() + c2 + c3;

            if (codon.equals("ATG")) {
                System.out.print(codon);
                inSeq = true;
            }
            else if (inSeq && (codon.equals("TAA") || codon.equals("TAG") || codon.equals("TGA"))) {
                System.out.println(codon);
                System.out.println();
                inSeq = false;
            }
            else if (inSeq) {
                System.out.print(codon);
            }
        }

        /*
        Need to shut a sequence if we finish the parse and we are still in a sequence.  Most likely biologists would
        not agree with just sticking a TGA on the end of an incomplete coding region, but I am going to do it anyway.
        */
        if( inSeq )
        {
            System.out.println( "TGA" );
        }
    }

    /**
     * This method finds the amino acids by working with the class CodonTable.java
     */
    public void findAminoAcids()
    {
        boolean inSeq = false;
        CodonTable table = new CodonTable();

        for( int i = 0; i < this.dna.length(); i += 3 ) {
            char c1 = this.dna.charAt(i);
            char c2 = this.dna.charAt(i + 1);
            char c3 = this.dna.charAt(i + 2);

            String codon = new Character(c1).toString() + c2 + c3;

            if (codon.equals("ATG")) {
                codon = table.getAminoAcidSequence(codon);
                System.out.print(codon);
                inSeq = true;
            } else if (inSeq && (codon.equals("TAA") || codon.equals("TAG") || codon.equals("TGA"))) {
                codon = table.getAminoAcidSequence(codon);
                System.out.println(codon);
                System.out.println();
                inSeq = false;
            } else if (inSeq) {
                codon = table.getAminoAcidSequence(codon);
                System.out.print(codon);
            }
        }

        //tags on a STOP incase sequence is incomplete
        if( inSeq )
        {
            System.out.println( "STOP" );
        }
    }

    /**
     * this method finds the dna sequence and turns it into mRNA
     */
    public void findmRNA()
    {
        boolean inSeq = false;

        for( int i = 0; i < this.dna.length(); i += 3 )
        {
            char c1 = this.dna.charAt( i );
            char c2 = this.dna.charAt( i + 1 );
            char c3 = this.dna.charAt( i + 2 );

            String codon = new Character( c1 ).toString() + c2 + c3;

            if( codon.equals( "ATG" ) )
            {
                codon = covertmRNA(codon);
                System.out.print( codon );
                inSeq = true;
            }
            else if( inSeq && ( codon.equals( "TAA" ) || codon.equals( "TAG" ) || codon.equals( "TGA" ) ) )
            {
                codon = covertmRNA(codon);
                System.out.println( codon );
                System.out.println();
                inSeq = false;
            }
            else if( inSeq )
            {
                codon = covertmRNA(codon);
                System.out.print( codon );
            }

        }

        // tags on a ACU at the end for mRNA
        if( inSeq )
        {
            System.out.println( "ACU" );
        }
    }
}
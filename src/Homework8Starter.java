/**
 * Homework8Starter.java:
 * Main class for homework 8
 *
 * @author Jordan Merkel
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Homework8Starter
{
    /**
     * Function main begins with program execution
     *
     * @param args Command line arguments (not used here)
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println( "Please enter the full path to the fasta file." );

        String filepath = scan.nextLine();

        File dnaFile = new File( filepath );

        Scanner fileScan = null;

        //Attempt to open a connection to the file
        try
        {
            fileScan = new Scanner( dnaFile );
        }
        catch ( FileNotFoundException fnfe )
        {
            System.out.println( "The file could not be found, shutting down" );
            System.exit( 1 );
        }

        //This is just more memory efficient, if you just used a String don't worry that is acceptable too
        StringBuilder dna = new StringBuilder();
        String option = new String();

        /*
        continuously loops until user types in an appropriate number
         */
        while (true)
        {
            System.out.println("Type 1 for DNA, 2 for mRNA, 3 for Amino Acid Sequence");
            option = scan.nextLine();

            if (option.equals("1"))
            {
                while (fileScan.hasNextLine())
                {
                    String line = fileScan.nextLine().trim();

                    //If we encounter the >, then we are at a new strand
                    if (line.length() > 0 && line.charAt(0) == '>')
                    {
                        DNAStrand strand = new DNAStrand(dna.toString());
                        strand.findPCRs();

                        System.out.println();
                        System.out.println(line);

                        dna = new StringBuilder();
                    }
                    //If we get a line with one character ignore it
                    else if (line.length() == 1)
                    {
                        //do nothing
                    }
                    //Otherwise the line is part of the DNA strand
                    else
                    {
                        dna.append(line);
                    }
                }

                break;
            }
            else if (option.equals("2"))
            {
                while (fileScan.hasNextLine())
                {
                    String line = fileScan.nextLine().trim();

                    //If we encounter the >, then we are at a new strand
                    if (line.length() > 0 && line.charAt(0) == '>')
                    {
                        DNAStrand strand = new DNAStrand(dna.toString());
                        strand.findmRNA();

                        System.out.println();
                        System.out.println(line);

                        dna = new StringBuilder();
                    }
                    //If we get a line with one character ignore it
                    else if (line.length() == 1)
                    {
                        //do nothing
                    }
                    //Otherwise the line is part of the DNA strand
                    else
                    {
                        dna.append(line);
                    }
                }

                break;
            }
            else if (option.equals("3"))
            {
                while (fileScan.hasNextLine())
                {
                    String line = fileScan.nextLine().trim();

                    //If we encounter the >, then we are at a new strand
                    if (line.length() > 0 && line.charAt(0) == '>')
                    {
                        DNAStrand strand = new DNAStrand(dna.toString());
                        strand.findAminoAcids();

                        System.out.println();
                        System.out.println(line);

                        dna = new StringBuilder();
                    }
                    //If we get a line with one character ignore it
                    else if (line.length() == 1)
                    {
                        //do nothing
                    }
                    //Otherwise the line is part of the DNA strand
                    else
                    {
                        dna.append(line);
                    }
                }

                break;
            }
            else
                {
                System.out.println("Please Type the appropriate option in.");
            }
        }

        //There will be one last DNA strand that is not printed out, this will print it out
        if (option.equals("1"))
        {
            DNAStrand strand = new DNAStrand(dna.toString());
            strand.findPCRs();
        }
        else if (option.equals("2"))
        {
            DNAStrand strand = new DNAStrand(dna.toString());
            strand.findmRNA();
        }
        else if (option.equals("3"))
        {
            DNAStrand strand = new DNAStrand(dna.toString());
            strand.findAminoAcids();
        }
        else
        {

        }
    }
}

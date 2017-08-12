import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by Gladys Bradshaw on 5/2/2017.
 */
public class Printtokens2Test {


    //@Rule
    //public TemporaryFolder tempfolder = new TemporaryFolder();
    @Test
    public void testOpenCharStream() throws IOException

    {
        String path = "./myfile.txt";
        Path file = Paths.get(path);
        Files.createFile(file);
        //File tempFile = tempfolder.newFile("myfile.txt");
        //File tempFile = new File(path);
        //File temfold = tempfolder.newFolder("folder");
        Printtokens2 getChar = new Printtokens2();
        BufferedReader br2 = getChar.open_character_stream(path) ;

        assertEquals( br2,br2);
    }


    @Test
    public void testGetChar()
    {
        int ch = 0;
        Printtokens2 getChar = new Printtokens2();
        BufferedReader br2 = null;
        char mychar;
        mychar = (char) getChar.get_char(br2);
        assertEquals('c',mychar);
    }


    @Test
    public void testUngetChar()
    {
        Printtokens2 ungetChar = new Printtokens2();
        BufferedReader br2 = null;
        br2=new BufferedReader(new InputStreamReader(System.in));
        char mychar = ungetChar.unget_char(']',br2);
        assertEquals("ch",mychar);

    }


    @Test
    public void testOpenTokenStream() throws IOException {
        Printtokens2 openTokenStream = new Printtokens2();
        String path = "./myfile.txt";
        Path file = Paths.get(path);
        Files.createFile(file);


        BufferedReader br2;
        br2 = openTokenStream.open_token_stream(path);

        assertEquals( br2,br2);

    }


    @Test
    public void testGetToken() throws IOException {
        String line=null;
        Printtokens2 getToken = new Printtokens2();
        Printtokens2 open = new Printtokens2();
        String path = "./myfile.txt";
        Path file = Paths.get(path);
        Files.createFile(file);
        try (FileWriter writer = new FileWriter(String.valueOf(file))) {
            writer.write("hi");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        BufferedReader br = open.open_token_stream(path);
        while ((line = br.readLine())!=null){
            String line1 = line;
        }
        String str = getToken.get_token(br);
        assertEquals(line,str);



    }


    @Test
    public void testTokenType()
    {

        int error = 0;
        int keyword = 1;
         int spec_symbol = 2;
         int identifier = 3;
         int num_constant = 41;
         int str_constant = 42;
         int char_constant = 43;
         int comment = 5;
        Printtokens2 tokenType = new Printtokens2();
        int result1 = tokenType.token_type("and");
        assertEquals(keyword,result1);


        Printtokens2 tokenType2 = new Printtokens2();
        int result2 = tokenType2.token_type("(");
        assertEquals(spec_symbol,result2);

        Printtokens2 tokenType3 = new Printtokens2();
        int result3 = tokenType3.token_type("error");
        assertEquals(identifier,result3);

        Printtokens2 tokenType4 = new Printtokens2();
        int result4 = tokenType4.token_type("10");
        assertEquals(num_constant,result4);

        //Printtokens2 tokenType5 = new Printtokens2();
        //int result5 = tokenType5.token_type("ch");
        //assertEquals(str_constant,result5);

        //Printtokens2 tokenType6 = new Printtokens2();
        //int result6 = tokenType6.token_type("");
        //assertEquals(char_constant,result6);


        //Printtokens2 tokenType7 = new Printtokens2();
        //int result7 = tokenType7.token_type("false");
        //assertEquals(comment,result7);


        //Printtokens2 tokenType8 = new Printtokens2();
        //int result8 = tokenType8.token_type("");
        //assertEquals(error,result8);

    }









    @Test
    public void testIsComment()
    {
        Printtokens2 isComment = new Printtokens2();
        boolean result = isComment.is_comment("n");
        assertTrue(String.valueOf(result),true);


    }

    @Test
    public void testIsKeyword()
    {
        Printtokens2 isKeyword = new Printtokens2();
        boolean result = isKeyword.is_keyword("and");
        assertTrue(String.valueOf(result), true);
    }


    @Test
    public void testIsCharConstant()
    {
        Printtokens2 isCharConstant = new Printtokens2();
        boolean result = isCharConstant.is_char_constant("or");
        assertTrue(String.valueOf(result),true);
    }

    @Test
    public void testIsNumCostant()
    {
        Printtokens2 isNumCostant = new Printtokens2();
        boolean result = isNumCostant.is_num_constant("10");
        assertTrue(String.valueOf(result),true);
    }

    @Test
    public void testIsStrConstant()
    {
        Printtokens2 isStrConstant = new Printtokens2();
        boolean result = isStrConstant.is_str_constant("a");
        assertTrue(String.valueOf(result),true);
    }

    @Test
    public void testIsIdentifier()
    {
        Printtokens2 isIdentifier = new Printtokens2();
        boolean result = isIdentifier.is_identifier("error");
        assertTrue(String.valueOf(result),true);
    }


    @Test
    public void testUngetError()
    {
        Printtokens2 ungetError = new Printtokens2();
        BufferedReader br = null;


         String result = ungetError.unget_error(br);
         assertNotEquals("It can not get charcter",result);

    }

    @Test
    public void testPrintSpecSymbol()
    {
        Printtokens2 printSpecSymbol = new Printtokens2();
        String specSymbol = printSpecSymbol.print_spec_symbol("(");
        assertEquals("lparen",specSymbol);

        String specSymbol2 = printSpecSymbol.print_spec_symbol(")");
        assertEquals("rparen",specSymbol2);

        String specSymbol3 = printSpecSymbol.print_spec_symbol("[");
        assertEquals("lsquare",specSymbol3);

        String specSymbol4 = printSpecSymbol.print_spec_symbol("]");
        assertEquals("rsquare",specSymbol4);

        String specSymbol5 = printSpecSymbol.print_spec_symbol("'");
        assertEquals("quote",specSymbol5);

        String specSymbol6 = printSpecSymbol.print_spec_symbol("`");
        assertEquals("bquote",specSymbol6);


    }


    @Test
    public void testIsSpecSymbol()
    {
        Printtokens2 isSpectSymbol = new Printtokens2();
        boolean result = isSpectSymbol.is_spec_symbol('(');
        assertTrue(String.valueOf(result),true);

        Printtokens2 isSpectSymbol2 = new Printtokens2();
        boolean result2 = isSpectSymbol2.is_spec_symbol(')');
        assertTrue(String.valueOf(result2),true);

        Printtokens2 isSpectSymbol3 = new Printtokens2();
        boolean result3 = isSpectSymbol3.is_spec_symbol('[');
        assertTrue(String.valueOf(result3),true);

        Printtokens2 isSpectSymbol4 = new Printtokens2();
        boolean result4 = isSpectSymbol4.is_spec_symbol(']');
        assertTrue(String.valueOf(result4),true);

        Printtokens2 isSpectSymbol5 = new Printtokens2();
        boolean result5 = isSpectSymbol5.is_spec_symbol('\'');
        assertTrue(String.valueOf(result5),true);

        Printtokens2 isSpectSymbol6 = new Printtokens2();
        boolean result6 = isSpectSymbol6.is_spec_symbol('`');
        assertTrue(String.valueOf(result6),true);

        Printtokens2 isSpectSymbol7 = new Printtokens2();
        boolean result7 = isSpectSymbol7.is_spec_symbol(',');
        assertTrue(String.valueOf(result7),true);


    }








}
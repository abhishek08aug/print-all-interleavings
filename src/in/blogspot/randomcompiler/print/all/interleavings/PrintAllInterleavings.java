package in.blogspot.randomcompiler.print.all.interleavings;

public class PrintAllInterleavings {
    public static void printAllInterleavings(String a, String b) {
        if(a == null && b== null) {
            return;
        }
        if(a == null) {
            System.out.println(b);
            return;
        }
        if(b == null) {
            System.out.println(a);
            return;
        }
        printAllInterleavingsRec(a, b, new StringBuilder(a.length() + b.length()), 0, 0, 0);
    }

    private static void printAllInterleavingsRec(String a, String b, StringBuilder interleave, int aIndex, int bIndex, int index) {
        if(aIndex >= a.length() && bIndex >= b.length()) {
            return;
        }
        if(aIndex <= a.length()-1 && bIndex <= b.length()-1) {
            StringBuilder aSb = new StringBuilder();
            aSb.append(interleave.toString());
            aSb.append(a.charAt(aIndex));
            printAllInterleavingsRec(a, b, aSb, aIndex+1, bIndex, index+1);
            
            StringBuilder bSb = new StringBuilder();
            bSb.append(interleave.toString());
            bSb.append(b.charAt(bIndex));
            printAllInterleavingsRec(a, b, bSb, aIndex, bIndex+1, index+1);
        }
        if(aIndex <= a.length()-1 && bIndex >= b.length()) {
            StringBuilder aSb = new StringBuilder();
            aSb.append(interleave.toString());
            aSb.append(a.substring(aIndex, a.length()));
            System.out.println(aSb.toString());
            return;
        }
        if(bIndex <= b.length()-1 && aIndex >= a.length()) {
            StringBuilder bSb = new StringBuilder();
            bSb.append(interleave.toString());
            bSb.append(b.substring(bIndex, b.length()));
            System.out.println(bSb.toString());
            return;
        }
    }
}

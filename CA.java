public class CA {
   public static void main(final String[] args) {
      final int n = Integer.parseInt(args[0]);
      final int r = Integer.parseInt(args[1]);
      final int numCells = 2 * n;
      final int numBits = 8;
      String binaryString = Integer.toBinaryString(r);
      for (int i = binaryString.length(); i < numBits; i++) {
         binaryString = "0" + binaryString;
      }
      System.out.println(binaryString);

      final boolean[] cells = new boolean[numCells];
      final boolean[] old = new boolean[numCells];
      cells[numCells / 2] = true;

      for (int t = 1; t < n; t++) {

         // draw current row
         for (int i = 0; i < numCells; i++) {
            if (cells[i])
               System.out.print("*");
            else
               System.out.print(" ");
         }
         System.out.println("");

         // save current row
         for (int i = 0; i < numCells; i++) {
            old[i] = cells[i];
         }

         // update cells according to rule 90
         for (int i = 1; i < numCells - 1; i++) {
            if (old[i - 1] && old[i] && old[i + 1]) {
               if (binaryString.substring(0, 1).equals("1")) {
                  cells[i] = true;
               } else {
                  cells[i] = false;
               }
            }
            if (old[i - 1] && old[i] && !old[i + 1]) {
               if (binaryString.substring(1, 2).equals("1")) {
                  cells[i] = true;
               } else {
                  cells[i] = false;
               }
            }
            if (old[i - 1] && !old[i] && old[i + 1]) {
               if (binaryString.substring(2, 3).equals("1")) {
                  cells[i] = true;
               } else {
                  cells[i] = false;
               }
            }
            if (old[i - 1] && !old[i] && !old[i + 1]) {
               if (binaryString.substring(3, 4).equals("1")) {
                  cells[i] = true;
               } else {
                  cells[i] = false;
               }
            }
            if (!old[i - 1] && old[i] && old[i + 1]) {
               if (binaryString.substring(4, 5).equals("1")) {
                  cells[i] = true;
               } else {
                  cells[i] = false;
               }
            }
            if (!old[i - 1] && old[i] && !old[i + 1]) {
               if (binaryString.substring(5, 6).equals("1")) {
                  cells[i] = true;
               } else {
                  cells[i] = false;
               }
            }
            if (!old[i - 1] && !old[i] && old[i + 1]) {
               if (binaryString.substring(6, 7).equals("1")) {
                  cells[i] = true;
               } else {
                  cells[i] = false;
               }
            }
            if (!old[i - 1] && !old[i] && !old[i + 1]) {
               if (binaryString.substring(7, 8).equals("1")) {
                  cells[i] = true;
               } else {
                  cells[i] = false;
               }
            }

         }
      }
   }
}

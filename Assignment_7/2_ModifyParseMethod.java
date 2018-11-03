public static void parse(File file) throws IOException {
  RandomAccessFile input = null;
  String line = null;

  try {
    input = new RandomAccessFile(file, "r");    // 1.add catch (FileNotFoundException e)
    while ((line = input.readLine()) != null) { // 2.add catch (IOException e)
      System.out.println(line);
    }
    return;
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    if (input != null) {
      input.close();  // 3.add throws IOException in the method signature
    }
  }
}

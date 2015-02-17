public class Test {

	public static void main(String[] args) {
		FileHandler fh = new FileHandler();

		VigenerCipher vc = new VigenerCipher();
		String plaintext0 = fh.readFile("plaintext.txt");
		String ciphertext0 = vc.permutation(plaintext0, "lemon");
		fh.writeFile("VigenerCipger.txt", ciphertext0);

		System.out.println("ciphertext0 is : " + ciphertext0);

		PermutationCipher pc = new PermutationCipher();
		String plaintext1 = fh.readFile("plaintext.txt");
		String ciphertext1 = pc.permutation(plaintext1, "14523");
		fh.writeFile("PermutationCipger.txt", ciphertext1);

		System.out.println("ciphertext1 is : " + ciphertext1);

	}

}

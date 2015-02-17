import java.util.ArrayList;
import java.util.HashMap;

public class PermutationCipher {

	public String permutation(String plaintext, String key) {
		int count = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Character> temp = new ArrayList<>();
		ArrayList<Integer> keychain = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - '0';
			hm.put(index, i);
		}

		for (int i = 0; i < plaintext.length(); i++) {

			if (plaintext.charAt(i) != ' ') {

				temp.add(plaintext.charAt(i));

				count++;

				if (count == 5) {

					for (int j = 0; j < 5; j++) {

						for (int k = 0; k < keychain.size(); k++) {

							if (keychain.get(k) == j) {
								sb.append(' ');
							}
						}
						sb.append(temp.get(hm.get(j + 1)));

					}
					count = 0;
					temp.clear();
					keychain.clear();
				}

			} else {
				keychain.add(count);
			}
		}

		return sb.toString();

	}

}

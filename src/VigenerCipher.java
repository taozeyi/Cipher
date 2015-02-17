import java.util.ArrayList;
import java.util.HashMap;

public class VigenerCipher {

	public String permutation(String plaintext, String keywords) {
		int count = 0;
		final String table = "abcdefghijklmnopqrstuvwxyz";
		ArrayList<Character> temp = new ArrayList<>();
		ArrayList<Character> keytable = new ArrayList<>();
		ArrayList<Integer> keychain = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		HashMap<Integer, Character> mh = new HashMap<Integer, Character>();

		for (int i = 0; i < table.length(); i++) {
			hm.put(table.charAt(i), i);
			mh.put(i, table.charAt(i));
		}

		for (int i = 0; i < keywords.length(); i++) {
			keytable.add(keywords.charAt(i));
		}
		for (int i = 0; i < plaintext.length(); i++) {
			if (plaintext.substring(i).length() >= 5) {
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
							int n = hm.get(temp.get(j));
							int l = hm.get(keytable.get(j));
							sb.append(mh.get((n + l % 26) % 26));

						}
						count = 0;
						temp.clear();
						keychain.clear();
					}

				} else {
					keychain.add(count);
				}
			} else {
				sb.append(plaintext.substring(i));
				break;
			}
		}
		return sb.toString();
	}

}

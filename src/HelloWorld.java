import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * LinkedList list = new LinkedList(); list.print(); list.reverse();
		 * list.print(); for (int i = 0; i < 10; ++i) list.addElem(new
		 * ListElem(Integer.toString(i))); list.print(); list.reverse();
		 * list.print();
		 */
		String filename = "";
		PrintMostRepeatedWords(filename);
		//////////////
		int[] array1 = new int[] { 1, 3, 5, 6, 7, 7, 7, 7, 4343, 12 };
		int[] array2 = new int[] { 5, 12, 1111, 323, 4343, 53434, 7 };
		int[] intersection = Intersection(array1, array2);
		System.out.println(Arrays.toString(intersection));

		////////////////
		String str = "java_language_is_sweet";
		System.out.println("Max Substring of : " + str);
		System.out.println(getMaxSubstring(str));

		////////////
		int[] arrayToSort = new int[] { 43, 7, 7, 6, 5, 3, 1 };
		int[] arrayToSort1 = arrayToSort.clone();
		System.out.println("Array to sort:");
		System.out.println(Arrays.toString(arrayToSort));
		BubbleSort(arrayToSort);
		System.out.println("Sorted array:");
		System.out.println(Arrays.toString(arrayToSort));

		//////////
		System.out.println("Array to sort by selection:");
		System.out.println(Arrays.toString(arrayToSort1));
		SelectionSort(arrayToSort1);
		System.out.println("Sorted array by selection:");
		System.out.println(Arrays.toString(arrayToSort1));

		////////////////
		int primeCount = 1;
		int sum = 2;
		int num = 3;
		while (primeCount < 1000) {
			if (prime(num)) {
				System.out.println(num);
				sum += num;
				++primeCount;
			}
			++num;
		}
		System.out.println("Sum of first 1000 primes = " + Integer.toString(sum));

		////////////////
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("four", 4);
		map.put("three", 3);
		map.put("two", 2);

		List<Entry<String, Integer>> mapList = new ArrayList<Entry<String, Integer>>(map.entrySet());

		Collections.sort(mapList, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {
				return a.getValue().compareTo(b.getValue());
			}
		});

		for (int i = 0; i < mapList.size(); ++i) {
			System.out.println(mapList.get(i).getKey() + " - " + mapList.get(i).getValue());
		}

		List<Integer> list = Arrays.asList(1, 2, 5, 3, 7, 6, 12, 4, 34, 53);
		Integer toFind = 12;
		int index = linearSearch(list, toFind);
		if (index >= 0) {
			System.out.println("Object " + toFind.toString() + " found at position " + ++index);
		} else {
			System.out.println("Object " + toFind.toString() + " not found");
		}

		boolean flag = binarySearchRec(list, toFind);
		if (flag) {
			System.out.println("Object " + toFind.toString() + " found at position " + ++index);
		} else {
			System.out.println("Object " + toFind.toString() + " not found");
		}

	}

	public static <T> int linearSearch(List<T> list, T obj) {
		for (int i = 0; i < list.size(); ++i) {
			if (obj.equals(list.get((i)))) {
				return i;
			}
		}
		return -1;
	}

	public static <T extends Comparable<T>> int binarySearch(List<T> list, T obj) {
		Collections.sort(list);
		int lower = 0;
		int higher = list.size() - 1;
		int middle;
		while (lower <= higher) {
			middle = (lower + higher) / 2;
			int comp = list.get(middle).compareTo(obj);
			if (comp == 0) {
				return middle;
			}
			if (comp < 0) {
				lower = middle + 1;
			} else {
				higher = middle - 1;
			}
		}
		return -1;
	}

	public static <T extends Comparable<T>> boolean binarySearchRec(List<T> list, T obj) {
		Collections.sort(list);
		return binarySearchRec(list, 0, list.size() - 1, obj);
	}

	public static <T extends Comparable<T>> boolean binarySearchRec(List<T> list, int lower, int higher, T obj) {
		if (lower > higher) {
			return false;
		}
		int middle = (lower + higher) / 2;
		int comp = list.get(middle).compareTo(obj);
		if (comp == 0) {
			return true;
		}
		if (comp < 0) {
			lower = middle + 1;
		} else {
			higher = middle - 1;
		}
		return binarySearchRec(list, lower, higher, obj);
	}

	public static Boolean prime(int N) {
		if (N % 2 == 0)
			return false;
		int sqrtN = (int) Math.sqrt(N);
		for (int i = 3; i <= sqrtN; i += 2) {
			if (N % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void InsertionSort(int[] array) {
		int swap;
		for (int i = 1; i < array.length; ++i) {
			swap = array[i];
			for (int j = i; j > 0; --j) {
				if (array[j - 1] > swap) {
					array[j] = array[j - 1];
				} else {
					array[j] = swap;
					break;
				}
			}
		}
	}

	public static void SelectionSort(int[] array) {
		int swap;
		int min;
		for (int i = 0; i < array.length - 1; ++i) {
			min = i;
			for (int j = i + 1; j < array.length; ++j) {
				if (array[min] > array[j]) {
					min = j;
				}
			}
			swap = array[i];
			array[i] = array[min];
			array[min] = swap;
		}
	}

	public static void BubbleSort(int[] array) {
		int swap;
		Boolean swapped = false;
		for (int i = array.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (array[j] > array[j + 1]) {
					swap = array[j];
					array[j] = array[j + 1];
					array[j + 1] = swap;
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}
	}

	public static String getMaxSubstring(String str) {
		if (str.equals("")) {
			return "";
		}
		// char[] charArray = str.toCharArray();
		String maxSubstring = "";
		String tmpSubstring = "" + str.charAt(0);
		for (int i = 1; i < str.length(); ++i) {
			int indx = tmpSubstring.indexOf(str.charAt(i));
			if (indx >= 0) {
				if (tmpSubstring.length() > maxSubstring.length()) {
					maxSubstring = new String(tmpSubstring);
				}
				tmpSubstring = tmpSubstring.substring(indx + 1);
				if (tmpSubstring.length() + str.length() - i <= maxSubstring.length())
					break;
			}
			tmpSubstring += str.charAt(i);
		}
		if (tmpSubstring.length() > maxSubstring.length()) {
			maxSubstring = new String(tmpSubstring);
		}
		return maxSubstring;
	}

	public static void PrintMostRepeatedWords(String filename) {
		String text;
		try {
			text = new String(Files.readAllBytes(Paths.get("D:\\work\\sample.txt")));
			String[] WordList = text.split("[\\p{Punct}\\s]+");
			Map<String, WordCount> map = new HashMap<String, WordCount>();
			for (int i = 0; i < WordList.length; ++i) {
				WordCount old = map.get(WordList[i]);
				if (old == null) {
					old = new WordCount(WordList[i], 1);
				} else {
					old.count += 1;
				}
				map.put(WordList[i], old);
			}
			ArrayList<WordCount> wordCountList = new ArrayList<WordCount>(map.values());
			Collections.sort(wordCountList, new ComparatorWordCountDesc());
			for (int i = 0; i < wordCountList.size(); ++i) {
				System.out.println(wordCountList.get(i).word + " : " + wordCountList.get(i).count);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[] Intersection(int[] arrayIn1, int[] arrayIn2) {
		int[] array1, array2;
		if (arrayIn1.length > arrayIn2.length) {
			array1 = arrayIn1;
			array2 = arrayIn2;
		} else {
			array1 = arrayIn2;
			array2 = arrayIn1;
		}
		Arrays.sort(array1);
		Arrays.sort(array2);
		List<Integer> intersection = new ArrayList<Integer>();
		for (int i = 0; i < array1.length; ++i) {
			if (i > 0 && array1[i] == array1[i - 1]) {
				continue;
			}
			if (Arrays.binarySearch(array2, array1[i]) >= 0) {
				intersection.add(array1[i]);
			}
		}
		return toIntArray(intersection);
	}

	public static int[] toIntArray(List<Integer> intList) {
		return intList.stream().mapToInt(Integer::intValue).toArray();
	}
}

class ComparatorWordCountDesc implements Comparator<WordCount> {
	@Override
	public int compare(WordCount o1, WordCount o2) {
		return o1.count < o2.count ? 1 : -1;
	}
}

class WordCount {
	String word;
	int count;

	WordCount(String aWord, int aCount) {
		word = aWord;
		count = aCount;
	}
}

class ListElem {
	String data = null;
	ListElem next = null;

	ListElem(String aData) {
		data = aData;
	}
}

class LinkedList {
	ListElem first = null;
	ListElem last = null;

	LinkedList() {
		first = new ListElem("Head");
		last = first;
	}

	void addElem(ListElem aElem) {
		last.next = aElem;
		last = last.next;
	}

	void reverse() {
		if (first == last)
			return;
		ListElem cElem = first.next;
		ListElem pElem = null;
		while (cElem != null) {
			ListElem t = cElem.next;
			cElem.next = pElem;
			pElem = cElem;
			cElem = t;
		}
		first.next = pElem;
	}

	void print() {
		ListElem elem = first.next;
		String val = "";
		while (elem != null) {
			val += elem.data + ", ";
			elem = elem.next;
		}
		System.out.println(val);
	}
}
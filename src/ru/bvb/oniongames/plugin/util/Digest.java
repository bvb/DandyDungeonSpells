package ru.bvb.oniongames.plugin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Digest
{
	public static String bin2hex(byte[] arrby)
	{
		StringBuffer stringBuffer = new StringBuffer();
		int n = arrby.length;
		for (int i = 0; i < n; ++i)
		{
			String string = Integer.toHexString(arrby[i] & 0xFF);
			if (string.length() == 1)
			{
				stringBuffer.append("0");
			}
			stringBuffer.append(string);
		}
		return stringBuffer.toString();
	}

	public static String long36String(long l)
	{
		if (l == 0L)
		{
			return "0";
		}
		StringBuilder stringBuilder = new StringBuilder();
		while (l > 0L)
		{
			int n = (int) (l % 36L);
			if (n < 10)
			{
				stringBuilder.append(n);
			} else
			{
				stringBuilder.append((char) (n + 87));
			}
			l /= 36L;
		}
		return new String(stringBuilder.reverse());
	}

	public static String long71String_Hiragana(long paramLong)
	{
		String[] arrayOfString = new String[70];
		arrayOfString[0] = "あ";
		arrayOfString[1] = "い";
		arrayOfString[2] = "う";
		arrayOfString[3] = "え";
		arrayOfString[4] = "お";
		arrayOfString[5] = "か";
		arrayOfString[6] = "き";
		arrayOfString[7] = "く";
		arrayOfString[8] = "け";
		arrayOfString[9] = "こ";
		arrayOfString[10] = "さ";
		arrayOfString[11] = "し";
		arrayOfString[12] = "す";
		arrayOfString[13] = "せ";
		arrayOfString[14] = "そ";
		arrayOfString[15] = "た";
		arrayOfString[16] = "ち";
		arrayOfString[17] = "つ";
		arrayOfString[18] = "て";
		arrayOfString[19] = "と";
		arrayOfString[20] = "な";
		arrayOfString[21] = "に";
		arrayOfString[22] = "ぬ";
		arrayOfString[23] = "ね";
		arrayOfString[24] = "の";
		arrayOfString[25] = "は";
		arrayOfString[26] = "ひ";
		arrayOfString[27] = "ふ";
		arrayOfString[28] = "へ";
		arrayOfString[29] = "ほ";
		arrayOfString[30] = "ま";
		arrayOfString[31] = "み";
		arrayOfString[32] = "む";
		arrayOfString[33] = "め";
		arrayOfString[34] = "も";
		arrayOfString[35] = "や";
		arrayOfString[36] = "ゆ";
		arrayOfString[37] = "よ";
		arrayOfString[38] = "ら";
		arrayOfString[39] = "り";
		arrayOfString[40] = "れ";
		arrayOfString[41] = "ろ";
		arrayOfString[42] = "わ";
		arrayOfString[43] = "を";
		arrayOfString[44] = "ん";
		arrayOfString[45] = "が";
		arrayOfString[46] = "ぎ";
		arrayOfString[47] = "ぐ";
		arrayOfString[48] = "げ";
		arrayOfString[49] = "ご";
		arrayOfString[50] = "ざ";
		arrayOfString[51] = "じ";
		arrayOfString[52] = "ず";
		arrayOfString[53] = "ぜ";
		arrayOfString[54] = "ぞ";
		arrayOfString[55] = "だ";
		arrayOfString[56] = "ぢ";
		arrayOfString[57] = "づ";
		arrayOfString[58] = "で";
		arrayOfString[59] = "ど";
		arrayOfString[60] = "ば";
		arrayOfString[61] = "び";
		arrayOfString[62] = "ぶ";
		arrayOfString[63] = "べ";
		arrayOfString[64] = "ぼ";
		arrayOfString[65] = "ぱ";
		arrayOfString[66] = "ぴ";
		arrayOfString[67] = "ぷ";
		arrayOfString[68] = "ぺ";
		arrayOfString[69] = "ぽ";
		if (0L == paramLong)
		{
			return arrayOfString[0];
		}
		int ln = arrayOfString.length;
		ArrayList<String> localArrayList = new ArrayList<>();
		long l;
		do
		{
			int j = (int) (paramLong % ln);
			l = paramLong / ln;
			localArrayList.add(arrayOfString[j]);
			paramLong = l;
		} while (l >= ln);

		if (l > 0L)
		{
			localArrayList.add(arrayOfString[(int) l]);
		}

		Collections.reverse(localArrayList);
		return joinList("", localArrayList);
	}

	public static String long71String_HiraganaDECODED(long paramLong)
	{
		String[] arrstring = new String[]{"\u3042", "\u3044", "\u3046", "\u3048", "\u304a", "\u304b", "\u304d", "\u304f", "\u3051", "\u3053", "\u3055", "\u3057", "\u3059", "\u305b", "\u305d", "\u305f", "\u3061", "\u3064", "\u3066", "\u3068", "\u306a", "\u306b", "\u306c", "\u306d", "\u306e", "\u306f", "\u3072", "\u3075", "\u3078", "\u307b", "\u307e", "\u307f", "\u3080", "\u3081", "\u3082", "\u3084", "\u3086", "\u3088", "\u3089", "\u308a", "\u308c", "\u308d", "\u308f", "\u3092", "\u3093", "\u304c", "\u304e", "\u3050", "\u3052", "\u3054", "\u3056", "\u3058", "\u305a", "\u305c", "\u305e", "\u3060", "\u3062", "\u3065", "\u3067", "\u3069", "\u3070", "\u3073", "\u3076", "\u3079", "\u307c", "\u3071", "\u3074", "\u3077", "\u307a", "\u307d"};
		if (0L == paramLong)
		{
			return arrstring[0];
		}
		int n = arrstring.length;
		ArrayList<String> arrayList = new ArrayList<String>();
		long l;
		do
		{
			int n2 = (int) (paramLong % (long) n);
			l = paramLong / (long) n;
			arrayList.add(arrstring[n2]);
			paramLong = l;
		} while (l >= (long) n);
		if (l > 0L)
		{
			arrayList.add(arrstring[(int) l]);
		}
		Collections.reverse(arrayList);
		return joinList("", arrayList);
	}

	public static String md5(String source)
	{
		try
		{
			MessageDigest digestMD5 = MessageDigest.getInstance("MD5");
			digestMD5.update(source.getBytes());
			byte[] paramString = digestMD5.digest();
			paramString = forceMakeSigned(paramString);

			StringBuffer resultBuffer = new StringBuffer();
			int j = paramString.length;
			int i = 0;
			while (i < j)
			{
				String str = Integer.toHexString(paramString[i] & 0xFF);
				if (str.length() == 1)
				{
					resultBuffer.append("0");
				}
				resultBuffer.append(str);
				i += 1;
			}
			return resultBuffer.toString();
		} catch (NoSuchAlgorithmException paramString)
		{
			paramString.printStackTrace();
		}
		return "";
	}

	public static long str36ToLong(String paramStringSource)
	{
		char[] paramString = paramStringSource.toCharArray();

		long l = 0L;
		long l2 = 0L;
		int n = paramString.length - 1;
		while (n > -1)
		{
			long l3;
			if ('0' <= paramString[n] && paramString[n] <= '9')
			{
				l3 = (long) ((double) l + (double) (paramString[n] - 48) * Math.pow(36.0, l2));
			} else if ('a' <= paramString[n] && paramString[n] <= 'z')
			{
				l3 = (long) ((double) l + (double) (paramString[n] - 97 + 10) * Math.pow(36.0, l2));
			} else
			{
				l3 = l;
				if ('A' <= paramString[n])
				{
					l3 = l;
					if (paramString[n] <= 'Z')
					{
						l3 = (long) ((double) l + (double) (paramString[n] - 65 + 10) * Math.pow(36.0, l2));
					}
				}
			}
			++l2;
			--n;
			l = l3;
		}
		return l;
	}

	public static long str71ToInt_Hiragana(String paramString)
	{
		paramString = paramString.toLowerCase();
		String[] arrayOfString = new String[70];
		arrayOfString[0] = "あ";
		arrayOfString[1] = "い";
		arrayOfString[2] = "う";
		arrayOfString[3] = "え";
		arrayOfString[4] = "お";
		arrayOfString[5] = "か";
		arrayOfString[6] = "き";
		arrayOfString[7] = "く";
		arrayOfString[8] = "け";
		arrayOfString[9] = "こ";
		arrayOfString[10] = "さ";
		arrayOfString[11] = "し";
		arrayOfString[12] = "す";
		arrayOfString[13] = "せ";
		arrayOfString[14] = "そ";
		arrayOfString[15] = "た";
		arrayOfString[16] = "ち";
		arrayOfString[17] = "つ";
		arrayOfString[18] = "て";
		arrayOfString[19] = "と";
		arrayOfString[20] = "な";
		arrayOfString[21] = "に";
		arrayOfString[22] = "ぬ";
		arrayOfString[23] = "ね";
		arrayOfString[24] = "の";
		arrayOfString[25] = "は";
		arrayOfString[26] = "ひ";
		arrayOfString[27] = "ふ";
		arrayOfString[28] = "へ";
		arrayOfString[29] = "ほ";
		arrayOfString[30] = "ま";
		arrayOfString[31] = "み";
		arrayOfString[32] = "む";
		arrayOfString[33] = "め";
		arrayOfString[34] = "も";
		arrayOfString[35] = "や";
		arrayOfString[36] = "ゆ";
		arrayOfString[37] = "よ";
		arrayOfString[38] = "ら";
		arrayOfString[39] = "り";
		arrayOfString[40] = "れ";
		arrayOfString[41] = "ろ";
		arrayOfString[42] = "わ";
		arrayOfString[43] = "を";
		arrayOfString[44] = "ん";
		arrayOfString[45] = "が";
		arrayOfString[46] = "ぎ";
		arrayOfString[47] = "ぐ";
		arrayOfString[48] = "げ";
		arrayOfString[49] = "ご";
		arrayOfString[50] = "ざ";
		arrayOfString[51] = "じ";
		arrayOfString[52] = "ず";
		arrayOfString[53] = "ぜ";
		arrayOfString[54] = "ぞ";
		arrayOfString[55] = "だ";
		arrayOfString[56] = "ぢ";
		arrayOfString[57] = "づ";
		arrayOfString[58] = "で";
		arrayOfString[59] = "ど";
		arrayOfString[60] = "ば";
		arrayOfString[61] = "び";
		arrayOfString[62] = "ぶ";
		arrayOfString[63] = "べ";
		arrayOfString[64] = "ぼ";
		arrayOfString[65] = "ぱ";
		arrayOfString[66] = "ぴ";
		arrayOfString[67] = "ぷ";
		arrayOfString[68] = "ぺ";
		arrayOfString[69] = "ぽ";

		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arrayOfString));
		int n = arrayOfString.length;
		long l = 0L;
		int n2 = paramString.length();
		for (int i = 0; i < n2; ++i)
		{
			long l2;
			l = l2 = l + (long) arrayList.indexOf(paramString.substring(i, i + 1));
			if (i == n2 - 1) continue;
			l = l2 * (long) n;
		}
		return l;
	}

	public static long str71ToInt_HiraganaDECODED(String string)
	{
		string = string.toLowerCase();
		String[] arrstring = new String[]{"\u3042", "\u3044", "\u3046", "\u3048", "\u304a", "\u304b", "\u304d", "\u304f", "\u3051", "\u3053", "\u3055", "\u3057", "\u3059", "\u305b", "\u305d", "\u305f", "\u3061", "\u3064", "\u3066", "\u3068", "\u306a", "\u306b", "\u306c", "\u306d", "\u306e", "\u306f", "\u3072", "\u3075", "\u3078", "\u307b", "\u307e", "\u307f", "\u3080", "\u3081", "\u3082", "\u3084", "\u3086", "\u3088", "\u3089", "\u308a", "\u308c", "\u308d", "\u308f", "\u3092", "\u3093", "\u304c", "\u304e", "\u3050", "\u3052", "\u3054", "\u3056", "\u3058", "\u305a", "\u305c", "\u305e", "\u3060", "\u3062", "\u3065", "\u3067", "\u3069", "\u3070", "\u3073", "\u3076", "\u3079", "\u307c", "\u3071", "\u3074", "\u3077", "\u307a", "\u307d"};
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arrstring));
		int n = arrstring.length;
		long l = 0L;
		int n2 = string.length();
		for (int i = 0; i < n2; ++i)
		{
			long l2;
			l = l2 = l + (long) arrayList.indexOf(string.substring(i, i + 1));
			if (i == n2 - 1) continue;
			l = l2 * (long) n;
		}
		return l;
	}

	public static String stringWithFill(String source, String filler, int numberOfTimes)
	{
		int lengthToFill = numberOfTimes - source.length();
		if (lengthToFill <= 0)
		{
			return source;
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(source);
		for (numberOfTimes = 0; numberOfTimes < lengthToFill; ++numberOfTimes)
		{
			stringBuilder.append(filler);
		}
		return new String(stringBuilder);
	}

	public static String stringWithFillLeft(String source, String filler, int numberOfTimes)
	{
		String str = "";
		numberOfTimes -= source.length();
		while (numberOfTimes > 0)
		{
			str = str + filler;
			numberOfTimes -= 1;
		}
		return str + source;
	}

	public static byte[] forceMakeSigned(byte[] input)
	{
		byte[] result = new byte[input.length];
		int d;

		for (int i = 0; i < input.length; i++)
		{
			byte b = input[i];
			d = (int)b;
			d = (d > 128 ? d - 256 : d);

			result[i] = (byte)(d);
		}

		return result;
	}

	public static String joinList(String delimiter, ArrayList<String> list)
	{
		String result = "";

		for (int i = 0; i < list.size(); i++)
		{
			String s = list.get(i);

			result += s;

			if (i != list.size() - 1)
			{
				result += delimiter;
			}
		}

		return result;
	}
}
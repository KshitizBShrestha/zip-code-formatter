package com.zipcode.zipcodesformatter.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.zipcode.zipcodesformatter.domain.ZipCodeRange;

@Service
public class ZipCodeSFormatterServiceImpl {

	Logger logger = LoggerFactory.getLogger(ZipCodeSFormatterServiceImpl.class);

	public String formatZipCodeRanges(String inZipCodeRanges) {

		if (inZipCodeRanges == null || inZipCodeRanges.isEmpty()) {
			return null;
		}

		List<ZipCodeRange> zipCodes = sortZipCodeRanges(formatZipCodes(inZipCodeRanges));

		zipCodes = mergeZipCodeRanges(zipCodes);

		return formatOutputZipCodes(zipCodes);
	}

	public List<ZipCodeRange> mergeZipCodeRanges(List<ZipCodeRange> inZipCodes) {

		List<ZipCodeRange> finalZipRanges = new ArrayList<>();

		ZipCodeRange tempZipRange = inZipCodes.get(0);
		for (ZipCodeRange zipRange : inZipCodes) {
			Integer maxZipCode = tempZipRange.getMaxZipCodeRange();
			Integer preMaxZipCode = zipRange.getMaxZipCodeRange();
			if (maxZipCode >= zipRange.getMinZipCodeRange()-1) {
				maxZipCode = maxZipCode >= preMaxZipCode ? maxZipCode : preMaxZipCode;
				tempZipRange.setMaxZipCodeRange(maxZipCode);
			} else {
				finalZipRanges.add(tempZipRange);
				tempZipRange = zipRange;
			}
		}

		finalZipRanges.add(tempZipRange);

		return finalZipRanges;
	}

	public List<ZipCodeRange> formatZipCodes(String zipCodesArray) {
		return Stream.of(zipCodesArray.split(" ")).map(s -> s.replaceAll("\\[|\\]", "").split(","))
				.filter(arr -> arr.length == 2)
				.map(arr -> new ZipCodeRange(parseStrToInt(arr[0]), parseStrToInt(arr[1])))
				.collect(Collectors.toList());
	}

	public List<ZipCodeRange> sortZipCodeRanges(List<ZipCodeRange> zipCodeRanges) {
		return zipCodeRanges.stream().sorted(Comparator.comparing(ZipCodeRange::getMinZipCodeRange))
				.collect(Collectors.toList());
	}

	public Integer parseStrToInt(String zipCode) {
		try {
			return Integer.parseInt(zipCode);
		} catch (NumberFormatException ne) {
			logger.error("NumberFormatException :" + ne.getMessage());
		}
		return 0;
	}

	public String formatOutputZipCodes(List<ZipCodeRange> zipCodes) {
		// Format the output to string format.
		return zipCodes.stream().map(ZipCodeRange::toString).collect(Collectors.joining());
	}

	// Print the zipcodes if needed.
	private void printZipCodes(List<ZipCodeRange> zipCodes) {
		zipCodes.forEach(zipCode -> System.out.println(zipCode.toString()));
	}
}

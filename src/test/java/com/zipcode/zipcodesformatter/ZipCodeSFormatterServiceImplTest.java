package com.zipcode.zipcodesformatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zipcode.zipcodesformatter.domain.ZipCodeRange;
import com.zipcode.zipcodesformatter.service.ZipCodeSFormatterServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipCodeSFormatterServiceImplTest {
	
	@Autowired
	private ZipCodeSFormatterServiceImpl serviceImpl;
	private List<ZipCodeRange> zipCodesList;
	private String zipCodes = "[94133,94133] [94200,94399]";
	private String zipCodes1 = "[94133,94133] [94200,94299] [94226,94399] ";
	
	@Before
	public void setup() {
		zipCodesList = new ArrayList<>();
		zipCodesList.add(new ZipCodeRange(94200,94299));
		zipCodesList.add(new ZipCodeRange(94133,94133));
		zipCodesList.add(new ZipCodeRange(94226,94399));
	}
	
	@Test
	public void formatZipCodeRangesTest() {
		String outputZipCodes = serviceImpl.formatZipCodeRanges(zipCodes1);
		assertThat(outputZipCodes.equals(zipCodes));
	}
	
	@Test
	public void mergeZipCodeRangesTest() {
		List<ZipCodeRange> outputZipCodeList = serviceImpl.mergeZipCodeRanges(zipCodesList);
		assertThat(outputZipCodeList.size() == 2);
	}
	
	@Test
	public void formatZipCodesTest() {
		List<ZipCodeRange> outputZipCodeList = serviceImpl.formatZipCodes(zipCodes);
		assertThat(outputZipCodeList.size() > 2);
	}
	
	@Test
	public void sortZipCodeRangesTest() {
		List<ZipCodeRange> sortedZipCodes = serviceImpl.sortZipCodeRanges(zipCodesList);
		assertThat(sortedZipCodes.get(0).getMinZipCodeRange() == 99133);
	}
	
	@Test
	public void formatOutputZipCodesTest() {
		String zipCodesOutput = serviceImpl.formatOutputZipCodes(zipCodesList);
		assertThat(zipCodesOutput.equals(zipCodes));
	}
	
	@Test
	public void parseStrToIntTest() {
		Integer zipCode = serviceImpl.parseStrToInt("99133");
		assertThat(zipCode == 99133);
	}
}

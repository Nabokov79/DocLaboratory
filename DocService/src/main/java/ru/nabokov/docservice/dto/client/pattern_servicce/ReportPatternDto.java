package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.data_service.TypeDto;

@Setter
@Getter
@AllArgsConstructor
public class ReportPatternDto {

    private Long Id;
    private TypeDto type;
    private TitlePatternDto titlePattern;
    private PatternSectionOneDto patternSectionOne;
    private PatternSectionTwoDto patternSectionTwo;
    private PatternSectionThreeDto patternSectionThree;
    private PatternSectionFourDto patternSectionFour;
    private PatternSectionFiveDto patternSectionFive;
    private PatternSectionSixDto patternSectionSix;
    private PatternSectionSevenDto patternSectionSeven;
}

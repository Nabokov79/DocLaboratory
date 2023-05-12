package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.title.TypeDto;

@Setter
@Getter
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "ReportPatternDto{" +
                "Id=" + Id +
                ", type=" + type +
                ", titlePattern=" + titlePattern +
                ", patternSectionOne=" + patternSectionOne +
                ", patternSectionTwo=" + patternSectionTwo +
                ", patternSectionThree=" + patternSectionThree +
                ", patternSectionFour=" + patternSectionFour +
                ", patternSectionFive=" + patternSectionFive +
                ", patternSectionSix=" + patternSectionSix +
                ", patternSectionSeven=" + patternSectionSeven +
                '}';
    }
}

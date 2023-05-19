package ru.nabokov.docservice.service;

import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.pattern.DrawingDto;
import ru.nabokov.docservice.dto.client.pattern.HeaderDto;
import ru.nabokov.docservice.dto.client.title.AddressDto;
import ru.nabokov.docservice.dto.client.title.TypeDto;

import java.util.LinkedList;
import java.util.List;

@Service
public class StringBuilderService {

    private static final String HOUSE = "д.";
    private static final String BUILDING = "к.";
    private static final String LETTER = "лит.";
    private static final CharSequence WHITESPACE = " ";
    private static final CharSequence WHITESPACE_NULL = "";
    private static final CharSequence COMMA = ", ";
    private static final CharSequence POINT = ". ";
    private static final CharSequence NUMBER = "№ ";

    public String toStringAddress(AddressDto addressDto) {
        String address = String.join(COMMA
                                   , addressDto.getStreet()
                                   , String.join(WHITESPACE_NULL
                                               , HOUSE
                                               , String.valueOf(addressDto.getHouseNumber()))
        );
        if (addressDto.getBuildingNumber() != null) {
            return String.join(COMMA
                             , address
                             , String.join(WHITESPACE_NULL
                                         , BUILDING
                                         , String.valueOf(addressDto.getBuildingNumber())));
        }
        if (addressDto.getLetter() != null) {
            return String.join(COMMA
                             , address
                             , String.join(WHITESPACE_NULL
                                         , LETTER
                                         , addressDto.getLetter()));
        }
        if (addressDto.getBuildingNumber() != null && addressDto.getLetter() != null) {
            return String.join(COMMA
                             , address
                             , String.join(WHITESPACE_NULL
                                         , BUILDING
                                         , String.valueOf(addressDto.getBuildingNumber()))
                                         , String.join(WHITESPACE_NULL
                                                     , LETTER
                                                     , addressDto.getLetter())
                             );
        } else {
            return address;
        }
    }

    public String toStringHeader(HeaderDto header) {
        return String.join(POINT
                         , String.valueOf(header.getNumber())
                         , header.getHeading());
    }

    public String toStringSubheading(Double number, String heading) {
        return String.join(WHITESPACE
                         , String.valueOf(number)
                         , heading);
    }

    public String toStringDrawing(DrawingDto drawingDto) {
        return String.join(WHITESPACE
                , drawingDto.getType()
                , NUMBER
                , String.join(WHITESPACE_NULL
                        , String.valueOf(drawingDto.getNumber())
                        , POINT )
                , drawingDto.getName());
    }

    public String toStringCountList(Integer count) {
        List<String> counts = new LinkedList<>();
        for (int i = 1; i == count; i++) {
            counts.add(String.valueOf(i));
        }
        return String.join(COMMA, counts);
    }

    public String toStringConclusion(TypeDto type , Integer number, String conclusion) {
        return String.join(WHITESPACE
                , type.getName()
                , NUMBER
                , String.valueOf(number)
                , conclusion);
    }
}

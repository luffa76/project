package edu.pusan.example.center.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pusan.example.center.domain.Center;
import edu.pusan.example.center.domain.dto.CenterDto;
import edu.pusan.example.center.repository.CenterRepository;
import edu.pusan.example.center.domain.Center;
import edu.pusan.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CenterService {
    private final CenterRepository centerRepository;
    private final UserRepository userRepository;
    
    public List<CenterDto> getCenterList() {
        List<Center> centerList = centerRepository.findAllByUsed("Y");
        ArrayList<CenterDto> result = new ArrayList<CenterDto>();

        for (Center center : centerList) {
            CenterDto temp = CenterDto.builder()
                    .centerId(center.getCenterId())
                    .title(center.getTitle())
                    .contents(center.getContents())
                    .insertDate(center.getInsertDate())
                    .used(center.getUsed())
                    .writerId(center.getWriter().getUserId())
                    .writerName(center.getWriter().getName())
                    .build();
            result.add(temp);
        }

        return result;
    }
    

    public void insertCenter(CenterDto centerDto) {
        Center center = centerDto.build();
        center.setUsed("Y");
        center.setWriter(userRepository.findById(centerDto.getWriterId()).get());
        centerRepository.save(center);
    }

    public CenterDto getCenter(int centerId) {
        Center center = centerRepository.findById(centerId).get();

        CenterDto centerDto = CenterDto.builder()
                                .centerId(center.getCenterId())
                                .title(center.getTitle())
                                .contents(center.getContents())
                                .insertDate(center.getInsertDate())
                                .updateDate(center.getUpdateDate())
                                .used(center.getUsed())
                                .writerId(center.getWriter().getUserId())
                                .writerName(center.getWriter().getName())
                                .build();

        return centerDto;
    }

    public void updateCenter(CenterDto centerDto) {
        Center center = centerRepository.findById(centerDto.getCenterId()).get();
        center.setTitle(centerDto.getTitle());
        center.setContents(centerDto.getContents());
        
        centerRepository.save(center);
    }

    public void deleteCenter(int centerId) {
        Center center = centerRepository.findById(centerId).get();
        center.setUsed("N");

        centerRepository.save(center);
    }
    
    
}


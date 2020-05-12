package wooteco.subway.admin.dto;


import wooteco.subway.admin.domain.Station;

import javax.validation.constraints.NotEmpty;

public class StationCreateRequest {
    @NotEmpty(message = "역 이름을 입력해야 한다.")
    private String name;

    public StationCreateRequest() {
    }

    public StationCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Station toStation() {
        return new Station(name);
    }
}

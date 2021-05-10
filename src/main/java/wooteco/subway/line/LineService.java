package wooteco.subway.line;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import wooteco.subway.exception.DataNotFoundException;

@Service
public class LineService {

    private final LineDao lineDao;

    public LineService(final LineDao lineDao) {
        this.lineDao = lineDao;
    }

    public LineResponse createLine(final LineRequest lineRequest) {
        final Line line = lineDao.save(lineRequest.toEntity());
        return LineResponse.from(line);
    }

    public List<LineResponse> findLines() {
        return lineDao.findAll().stream().
            map(LineResponse::from).
            collect(Collectors.toList());
    }

    public LineResponse findLine(final Long id) {
        final Line line = lineDao.findById(id)
            .orElseThrow(() -> new DataNotFoundException("해당 Id의 노선이 없습니다."));
        return LineResponse.from(line);
    }

    public void updateLine(final Long id, final LineRequest lineRequest) {
        lineDao.update(new Line(id, lineRequest.getName(), lineRequest.getColor()));
    }

    public void deleteLine(final Long id) {
        lineDao.deleteById(id);
    }
}

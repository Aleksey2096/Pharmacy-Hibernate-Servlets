package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.PrescriptionRequestDTO;
import by.academy.pharmacy.entity.PrescriptionRequestStatus;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import static by.academy.pharmacy.entity.Constant.COLON;
import static by.academy.pharmacy.entity.Constant.EMPTY_PATH;
import static by.academy.pharmacy.entity.Constant.IMAGE;
import static by.academy.pharmacy.entity.Constant.IMG_PRESCRIPTION_SCAN;
import static by.academy.pharmacy.entity.Constant.JPG;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUEST_ID_DB;

public final class PrescriptionRequestDtoExtractor implements Extractor<PrescriptionRequestDTO> {
    @Override
    public PrescriptionRequestDTO extract(final HttpServletRequest request) {
        PrescriptionRequestDTO prescriptionRequestDTO = PrescriptionRequestDTO.builder()
                .id(RequestDataUtil.getLong(PRESCRIPTION_REQUEST_ID_DB, request))
                .uploadDateTime(LocalDateTime.now())
                .prescriptionRequestStatus(PrescriptionRequestStatus.UNPROCESSED)
                .build();
        String prescriptionScanPath = IMG_PRESCRIPTION_SCAN
                + prescriptionRequestDTO.getUploadDateTime().toString().replace(COLON, EMPTY_PATH)
                + JPG;
        prescriptionRequestDTO.setPrescriptionScanPath(prescriptionScanPath);
        RequestDataUtil.saveFile(
                request.getServletContext().getRealPath(EMPTY_PATH) + prescriptionScanPath, request,
                IMAGE);
        return prescriptionRequestDTO;
    }
}

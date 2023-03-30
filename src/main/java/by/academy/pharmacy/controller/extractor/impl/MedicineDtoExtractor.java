package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.dto.MedicineDTO;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

import static by.academy.pharmacy.entity.Constant.APPROVAL_DATE_DB;
import static by.academy.pharmacy.entity.Constant.EMPTY_PATH;
import static by.academy.pharmacy.entity.Constant.IMAGE;
import static by.academy.pharmacy.entity.Constant.IMG_MEDICINE;
import static by.academy.pharmacy.entity.Constant.IS_NONPRESCRIPTION_DB;
import static by.academy.pharmacy.entity.Constant.JPG;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ID_DB;
import static by.academy.pharmacy.entity.Constant.TITLE;

public final class MedicineDtoExtractor implements Extractor<MedicineDTO> {
    @Override
    public MedicineDTO extract(final HttpServletRequest request) {
        MedicineDTO medicineDTO = MedicineDTO.builder()
                .id(RequestDataUtil.getLong(MEDICINE_ID_DB, request))
                .title(RequestDataUtil.getString(TITLE, request))
                .isNonprescription(
                        RequestDataUtil.getDBoolean(IS_NONPRESCRIPTION_DB,
                                request))
                .approvalDate(
                        RequestDataUtil.getDate(APPROVAL_DATE_DB, request))
                .build();
        String medicineImagePath = IMG_MEDICINE + medicineDTO.getTitle() + JPG;
        medicineDTO.setMedicineImagePath(medicineImagePath);
        RequestDataUtil.saveFile(
                request.getServletContext().getRealPath(EMPTY_PATH)
                        + medicineImagePath, request, IMAGE);
        return medicineDTO;
    }

}

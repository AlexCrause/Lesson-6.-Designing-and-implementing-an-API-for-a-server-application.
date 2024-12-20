package com.example.personalnotetaking.service;

import com.example.personalnotetaking.model.Remark;
import com.example.personalnotetaking.repository.RemarkRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RemarkServiceImpl implements RemarkService{

    private final RemarkRepo remarkRepo;


    @Override
    public Remark addRemark(Remark remark) {
        return remarkRepo.save(remark);
    }

    @Override
    public Remark getRemarkById(Long id) {
        return remarkRepo.findById(id).orElseThrow(null);
    }

    @Override
    public List<Remark> getAllRemarks() {
        return remarkRepo.findAll();
    }

    @Override
    public Remark updateRemark(Remark remark) {
        Remark remarkById = getRemarkById(remark.getId());
        remarkById.setTitle(remark.getTitle());
        remarkById.setContent(remark.getContent());
        return remarkRepo.save(remarkById);
    }

    @Override
    public void deleteRemark(Long id) {
        Remark remarkById = getRemarkById(id);
        remarkRepo.delete(remarkById);
    }
}

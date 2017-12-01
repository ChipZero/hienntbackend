package com.hiennt.pizza.controller;

import com.hiennt.pizza.entity.TblProtype;
import com.hiennt.pizza.service.IProtypeService;
import com.hiennt.pizza.utils.HienntException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api")
public class ProtypeController {
    @Autowired
    private IProtypeService protypeService;
    private static final Logger logger = LoggerFactory.getLogger(ProtypeController.class);

    @GetMapping(path="/protype/all")
    public List<TblProtype> getAll(){
        List<TblProtype> protypes = protypeService.getAll();
        return protypes;
    }

    @GetMapping("/protype/{id}")
    public TblProtype getById(@PathVariable("id") Integer id){
        TblProtype protype = protypeService.getById(id);
        return protype;
    }

    @PostMapping(path="/protype/add")
    public String addNew(@RequestBody TblProtype protype){
        JSONObject result = new JSONObject();
        try {
            protypeService.add(protype);
            result.put("code", "200");
            result.put("message", "add new protype success!");
            return result.toString();
        } catch (HienntException e) {
            logger.error("Add protype MyError:", e);
            result.put("code", e.getErrorCode());
            result.put("message", e.getMessage());
            return result.toString();
        } catch (Exception e) {
            logger.error("Add protype Error :", e);
            result.put("message", e);
            return result.toString();
        }
    }

    @PutMapping("/protype/update")
    public String update(@RequestBody TblProtype protype){
        JSONObject result = new JSONObject();
        try {
            protypeService.update(protype);
            result.put("code", "200");
            result.put("message", "update protype success!");
            return result.toString();
        } catch (HienntException e) {
            logger.error("update protype MyError:", e);
            result.put("code", e.getErrorCode());
            result.put("message", e.getMessage());
            return result.toString();
        } catch (Exception e) {
            logger.error("update protype MyError:", e);
            result.put("message", e);
            return result.toString();
        }
    }

    @DeleteMapping("/protype/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        JSONObject result = new JSONObject();
        try {
            protypeService.delete(id);
            result.put("code", "200");
            result.put("message", "delete protype success!");
            return result.toString();
        }catch (Exception e) {
            logger.error("delete protype Error:", e);
            result.put("message", e);
            return result.toString();
        }
    }
}

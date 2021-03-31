package com.calculadoracalorias.calculadoracalorias.services;

import com.calculadoracalorias.calculadoracalorias.dto.IngredienteCaloriasDTO;
import com.calculadoracalorias.calculadoracalorias.dto.IngredienteDTO;
import com.calculadoracalorias.calculadoracalorias.dto.PlatoDTO;
import com.calculadoracalorias.calculadoracalorias.dto.ResponseDTO;
import com.calculadoracalorias.calculadoracalorias.repositories.CalculadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {
    @Autowired
    private CalculadoraRepository calculadoraRepository;

    @Override
    public ResponseDTO crearResponsePlato(PlatoDTO plato) {
        ResponseDTO response = new ResponseDTO();

        response.setCaloriasTotalPlato(caloriasTotales(plato));
        response.setCaloriasPorIngrediente(caloriasPorIngrediente(plato.getIngredientes()));
        response.setIngredienteMaxCalorias(ingredienteMaxCalorias(plato.getIngredientes()));

        return response;
    }

    @Override
    public List<ResponseDTO> crearResponsePlatos(List<PlatoDTO> platos) {
        List<ResponseDTO> responseList = new ArrayList<ResponseDTO>();

        for (PlatoDTO plato : platos) {
            responseList.add(crearResponsePlato(plato));
        }

        return responseList;
    }

    @Override
    public int caloriasTotales(PlatoDTO plato) {
        int caloriasTotales = 0;

        for (IngredienteDTO ingrediente : plato.getIngredientes()) {
            IngredienteCaloriasDTO ingredienteCalorias = calculadoraRepository.findIngredienteByName(ingrediente.getNombre());
            int calorias = ingredienteCalorias != null ? ingredienteCalorias.getCalories() : 0;

            caloriasTotales += ingrediente.getPeso() * calorias;
        }

        return caloriasTotales;
    }

    @Override
    public List<IngredienteCaloriasDTO> caloriasPorIngrediente(List<IngredienteDTO> ingredientes) {
        List<IngredienteCaloriasDTO> listIngredientes = new ArrayList<IngredienteCaloriasDTO>();

        for (IngredienteDTO ingrediente : ingredientes) {
            IngredienteCaloriasDTO ingredienteCaloriasDTO = calculadoraRepository.findIngredienteByName(ingrediente.getNombre());

            if (ingredienteCaloriasDTO != null)
                listIngredientes.add(ingredienteCaloriasDTO);
        }

        return listIngredientes;
    }

    @Override
    public IngredienteCaloriasDTO ingredienteMaxCalorias(List<IngredienteDTO> ingredientes) {
        int maxCalorias = -1;
        IngredienteCaloriasDTO ingredienteMaxCalorias = null;

        for (IngredienteDTO ingrediente : ingredientes) {
            IngredienteCaloriasDTO ingredienteCaloriasDTO = calculadoraRepository.findIngredienteByName(ingrediente.getNombre());

            if (ingredienteCaloriasDTO != null) {
                if (ingredienteCaloriasDTO.getCalories() > maxCalorias) {
                    maxCalorias = ingredienteCaloriasDTO.getCalories();
                    ingredienteMaxCalorias = ingredienteCaloriasDTO;
                }
            }
        }

        return ingredienteMaxCalorias;
    }
}

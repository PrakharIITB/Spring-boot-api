package com.example.api;

import com.example.api.API.model.Manufacturer;

import java.util.*;

public class ManufacturerDataGenerator {
    private static final String[] BASE_COMPANY_NAMES = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa", "Lambda", "Mu", "Nu", "Xi", "Omicron", "Pi", "Rho", "Sigma", "Tau", "Upsilon", "Phi", "Chi", "Psi", "Omega", "QuantumWorks", "InnoSphere", "VertexDynamics", "AstraTech", "NovaForge", "PioneerIndustries", "OmniSolutions", "EclipseVentures", "FusionCraft", "ZenithLabs", "ApexInnovations", "GenesisSystems", "SkylineTech", "NexusIndustries", "TitanEngineering", "VanguardTechnologies", "PrimeFusion", "CrystalTech", "SpectraDynamics", "Synthetix", "InfinityWorks", "LunarForge", "CatalystLabs", "VertexVentures", "SummitIndustries", "EclipseCraft", "PioneerTech", "QuantumDynamics", "AstraLabs", "ZenithVentures", "NebulaEnterprises", "PulseInnovations", "QuantumLeap", "VertexSolutions", "StratosTech", "HelixIndustries", "OrionVentures", "FusionLabs", "AtlasDynamics", "NovaSolutions", "PinnacleEngineering", "SpectraTech", "VortexSystems", "ZenithWorks", "EchelonCraft", "OmegaInnovations", "GenesisVentures", "AuroraTech", "SummitSolutions", "NexusLabs", "TitanVentures", "ApexDynamics", "PioneerWorks", "LunarVentures", "VertexLabs", "InnoForge", "PrimeVentures", "CelestialTech", "StratosDynamics", "HelixVentures"};
    private static final String[] LOCATIONS = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
    private static final String[] NATURE_OF_BUSINESS = {"small_scale", "medium_scale", "large_scale"};
    private static final String[] MANUFACTURING_PROCESSES = {"moulding", "3d_printing", "casting", "coating"};


    public static List<Manufacturer> generateManufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 84; i++) {
            String supplierId = "SUPP" + String.format("%04d", i);

            String companyName = BASE_COMPANY_NAMES[i-1];
            String website = "www." + companyName.replace(" ", "").toLowerCase() + ".com";
            String location = LOCATIONS[random.nextInt(LOCATIONS.length)];
            String natureOfBusiness = NATURE_OF_BUSINESS[random.nextInt(NATURE_OF_BUSINESS.length)];
            String manufacturingProcess = MANUFACTURING_PROCESSES[random.nextInt(MANUFACTURING_PROCESSES.length)];

            Manufacturer manufacturer = new Manufacturer(supplierId, companyName, website, location, natureOfBusiness, manufacturingProcess);
            manufacturers.add(manufacturer);
        }

        return manufacturers;
    }
}

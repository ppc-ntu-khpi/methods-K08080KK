//package domain;

public class Exercise {
    public static String Calculate(int cidr){
        if(cidr<0||cidr>32){
            return "Invalid CIDR";
        }

        int mask = 0xFFFFFFFF << (32 - cidr);
        int network = 0;
        int broadcast = network | ~mask;

        String subnetMask = String.format("%d.%d.%d.%d",
            (mask>>>24)&0XFF,
            (mask>>>16)&0XFF,
            (mask>>>8)&0XFF,
            mask & 0xFF);

        String rangeStart = String.format("%d.%d.%d.%d",
            (network>>>24)&0XFF,
            (network>>>16)&0XFF,
            (network>>>8)&0XFF,
            network & 0xFF);
        
        String rangeEnd = String.format("%d.%d.%d.%d",
            (broadcast>>>24)&0XFF,
            (broadcast>>>16)&0XFF,
            (broadcast>>>8)&0XFF,
            broadcast & 0xFF);
        
        return "Mask: " + subnetMask + "\nRange: " + rangeStart + " - " + rangeEnd;
    }
}

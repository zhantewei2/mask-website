export const navData = [
    {name: "Home", href: "/"},
    {
        name: "CE", children: [
            {name: "FFP1 NR", id: "FFP1 NR"},
            {name: "FFP2 NR", id: "FFP2 NR"},
            {name: "FFP3 NR", id: "FFP3 NR"}
        ]
    },
    {
        name: "NIOSH", children: [
            {name: "N95", id: "N95"},
            {name: "N99", id: "N99"},
            {name: "FDA", id: "FDA"}
        ]
    },
    {
        name: "AS/NZS", children: [
            {name: "P1", id: "P1"},
            {name: "P2", id: "P2"},
        ]
    },
    {
        name: "Contact Us", href: "/concatUs"
    }
];

export const typeData = [
    {id: "N95", types: ["N95"], navLabel: ["NIOSH", "N95"]},
    {id: "N99", types: ["N99"], navLabel: ["NIOSH", "N99"]},
    {id: "FDA", types: ["FDA"], navLabel: ["NIOSH", "FDA"]},

    {id: "FFP1 NR", types: ["FFP1 NR"], navLabel: ["CE", "FFP1 NR"]},
    {id: "FFP2 NR", types: ["FFP2 NR"], navLabel: ["CE", "FFP2 NR"]},
    {id: "FFP3 NR", types: ["FFP3 NR"], navLabel: ["CE", "FFP3 NR"]},

    {types: ["P1"], id: "P1", typeName: ["AS/NZS", "P1"]},
    {types: ["P2"], id: "P2", typeName: ["AS/NZS", "P2"]},

    {id: "CE", types: ["FFP1 NR", "FFP2 NR", "FFP3 NR"], navLabel: ["CE"]},
    {id: "AS/NZS", types: ["P1", "P2"], navLabel: ["AS/NZS"]},
    {id: "NIOSH", types: ["N95", "N99", "FDA"], navLabel: ["NIOSH"]}
];
import type { Route } from "./+types/carte";

export function meta({ }: Route.MetaArgs) {
    return [
        { title: "Lateb - Carte des bières" },
        { name: "description", content: "L'Association des Teks Experts en Bière" },
    ];
}

function BeerCard({ biere }: { biere: typeof bieres_list[number] }) {
    return (
        <div className="flex flex-row items-center justify-center w-full max-w-md p-4 m-2">
            <img src={biere.image} alt={biere.name} className="w-1/3 h-auto" />
            <div className="flex flex-col justify-between p-4">
                <div className="flex flex-row items-center">
                    <h2 className="text-2xl font-bold text-primary">{biere.name} - {biere.alcool}°</h2>
                    <span className="ml-2 text-sm text-gray-500">{biere.cl} cl</span>
                </div>
                <p className="text-gray-500">{biere.type} | {biere.brasserie}</p>
                <p className="text-gray-700">{biere.description}</p>
            </div>
        </div>
    );
}

const Carte = () => {
    const groupedBieres = bieres_list.reduce((acc, biere) => {
        acc[biere.arrivage] = acc[biere.arrivage] || [];
        acc[biere.arrivage].push(biere);
        return acc;
    }, {} as Record<string, typeof bieres_list>);

    return (
        <div className="flex flex-col items-center min-h-screen border-8 border-amber-600 bg-cover bg-center bg-no-repeat"
            style={{
                backgroundImage: "url('/lateb_logo.png')",
                backgroundSize: "contain",
                backgroundColor: "rgba(251, 235, 207, 0.8)",
                backgroundBlendMode: "overlay"
            }}>
            <header className="flex flex-col items-center justify-center w-full h-1/2 pt-4">
                <h1 className="text-4xl sm:text-5xl md:text-6xl lg:text-7xl mb-2 text-primary text-center">
                    Carte des bières
                </h1>
                <p className="text-xl sm:text-2xl md:text-3xl text-gray-700 text-center">
                    Découvrez notre sélection de bières !
                </p>
            </header>

            <div className="carte flex flex-col">
                {Object.entries(groupedBieres)
                    .sort(([a], [b]) => new Date(b).getTime() - new Date(a).getTime())
                    .map(([arrivage, bieres]) => (
                        <div key={arrivage} className="w-full">
                            <h2 className="text-2xl font-bold text-primary text-center my-4">
                                Arrivage du {new Date(arrivage).toLocaleDateString("fr", {
                                    weekday: 'long',
                                    year: 'numeric',
                                    month: 'long',
                                    day: 'numeric'
                                })}
                            </h2>
                            <div className="flex flex-wrap justify-center">
                                {bieres.map((biere) => (
                                    <BeerCard key={biere.id} biere={biere} />
                                ))}
                            </div>
                        </div>
                    ))}
            </div>
        </div>
    );
};

const bieres_list = [
    {
        id: 1,
        name: "Bière 1",
        brasserie: "Brasserie 1",
        type: "Type 1",
        cl: 33,
        alcool: 5,
        description: "Description de la bière 1",
        image: "default_beer.png",
        arrivage: "2023-10-01",
    },
    {
        id: 2,
        name: "Bière 2",
        brasserie: "Brasserie 2",
        type: "Type 2",
        cl: 33,
        alcool: 5,
        description: "Description de la bière 2",
        image: "default_beer.png",
        arrivage: "2023-10-03",
    },
    {
        id: 3,
        name: "Bière 3",
        brasserie: "Brasserie 3",
        type: "Type 3",
        cl: 33,
        alcool: 5,
        description: "Description de la bière 3",
        image: "default_beer.png",
        arrivage: "2023-10-01",
    },
    {
        id: 4,
        name: "Bière 4",
        brasserie: "Brasserie 4",
        type: "Type 4",
        cl: 33,
        alcool: 5,
        description: "Description de la bière 4",
        image: "default_beer.png",
        arrivage: "2023-10-01",
    },
    {
        id: 5,
        name: "Bière 5",
        brasserie: "Brasserie 5",
        type: "Type 5",
        cl: 33,
        alcool: 5,
        description: "Description de la bière 5",
        image: "default_beer.png",
        arrivage: "2023-10-03",
    }
];

export default Carte;

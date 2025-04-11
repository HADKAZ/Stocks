import type { Route } from "./+types/carte";

export function meta({ }: Route.MetaArgs) {
    return [
        { title: "Lateb - Carte des bières" },
        { name: "description", content: "L'Association des Teks Experts en Bière" },
    ];
}

const Carte = () => {
    return (
        <div className="flex flex-col items-center min-h-screen border-8 border-amber-600 bg-cover bg-center bg-no-repeat"
            style={{ backgroundImage: "url('/lateb_logo.png')", backgroundSize: "contain", backgroundColor: "rgba(251, 235, 207, 0.8)", backgroundBlendMode: "overlay" }}>
            <div className="flex flex-col items-center justify-center w-full h-1/2 pt-4" >
                <h1 className="text-4xl sm:text-5xl md:text-6xl lg:text-7xl mb-2 text-primary text-center">
                    Carte des bières
                </h1>
                <p className="text-xl sm:text-2xl md:text-3xl text-gray-700 text-gray text-center">Découvrez notre sélection de bières !</p>
            </div>
        </div>
    );
}

export default Carte;